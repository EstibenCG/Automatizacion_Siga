package co.com.AutoSiga.tasks;

import co.com.AutoSiga.models.DatosUsuario;
import co.com.AutoSiga.utils.hooks.SesionVariable;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.apache.commons.lang3.RandomStringUtils;

import static co.com.AutoSiga.userinterface.crearrol.ROL_EN_LISTA;
import static co.com.AutoSiga.userinterface.editarusuario.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class editar_usuario implements Task {

    private final DatosUsuario datos;

    public editar_usuario(DatosUsuario datos) {
        this.datos = datos;
    }

    String numero = RandomStringUtils.random(2, false, true);
    @Override
    public <T extends Actor> void performAs(T actor) {

        String correoFinal = datos.getCorreo() + numero;

        actor.attemptsTo(
                Click.on(BTN_EDITAR_USUARIO),
                Enter.theValue(datos.getCorreo()+numero).into(CORREO),
                Enter.theValue(datos.getContraseña()).into(CONTRASENA),
                SelectFromOptions.byVisibleText(datos.getRol()).from(DROPDOWN_ROL),
                Click.on(BTN_ACTUALIZAR)
        );

        actor.remember(SesionVariable.CORREO.toString(), correoFinal);

        actor.attemptsTo(
                WaitUntil.the(USUARIO_EN_LISTA(correoFinal), isVisible())
                        .forNoMoreThan(8).seconds()
        );

        actor.attemptsTo(
                Scroll.to(USUARIO_EN_LISTA(correoFinal))
        );
    }

    public static editar_usuario conDatos(DatosUsuario datos) {
        return Instrumented.instanceOf(editar_usuario.class).withProperties(datos);
    }
}