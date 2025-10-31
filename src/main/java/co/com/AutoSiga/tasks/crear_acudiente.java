package co.com.AutoSiga.tasks;

import co.com.AutoSiga.models.DatosAcudiente;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.AutoSiga.userinterface.crearacudiente.*;

public class crear_acudiente implements Task {

    private final DatosAcudiente datos;

    public crear_acudiente(DatosAcudiente datos) {
        this.datos = datos;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_MODULO_ACUDIENTES),
                Enter.theValue(datos.getNombre()).into(NOMBRE),
                Enter.theValue(datos.getApellido()).into(APELLIDO),
                Enter.theValue(datos.getCorreo()).into(CORREO),
                Click.on(BTN)
        );
    }

    public static crear_acudiente conDatos(DatosAcudiente datos) {
        return Instrumented.instanceOf(crear_acudiente.class).withProperties(datos);
    }
}
