package co.com.AutoSiga.tasks;

import co.com.AutoSiga.models.DatosUsuario;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import static co.com.AutoSiga.userinterface.crearusuario.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class crear_usuario implements Task {

    private final DatosUsuario datos;

    public crear_usuario(DatosUsuario datos) {
        this.datos = datos;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(datos.getCorreo()).into(CORREO),
                Enter.theValue(datos.getContraseña()).into(CONTRASENA),
                SelectFromOptions.byVisibleText(datos.getRol()).from(DROPDOWN_ROL),
                Click.on(BTN_REGISTRAR)
        );
        theActorInTheSpotlight().remember("CORREO_USUARIO_CREADO", datos.getCorreo());
    }

    public static crear_usuario conDatos(DatosUsuario datos) {
        return Instrumented.instanceOf(crear_usuario.class).withProperties(datos);
    }
}