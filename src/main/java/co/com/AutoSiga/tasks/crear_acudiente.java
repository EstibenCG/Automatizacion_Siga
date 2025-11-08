package co.com.AutoSiga.tasks;

import co.com.AutoSiga.models.DatosAcudiente;
import co.com.AutoSiga.utils.hooks.SesionVariable;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.apache.commons.lang3.RandomStringUtils;

import static co.com.AutoSiga.userinterface.crearacudiente.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class crear_acudiente implements Task {

    private final DatosAcudiente datos;

    public crear_acudiente(DatosAcudiente datos) {
        this.datos = datos;
    }
    String Numero = RandomStringUtils.random(2, false, true);
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_MODULO_ACUDIENTES),
                Enter.theValue(datos.getNombre()+Numero).into(NOMBRE),
                Enter.theValue(datos.getApellido()+Numero).into(APELLIDO),
                Enter.theValue(datos.getCorreo()+Numero).into(CORREO),
                Click.on(BTN)
        );
        theActorInTheSpotlight().remember(SesionVariable.NOMBRE.toString(), datos.getNombre() +Numero);
    }

    public static crear_acudiente conDatos(DatosAcudiente datos) {
        return Instrumented.instanceOf(crear_acudiente.class).withProperties(datos);
    }
}
