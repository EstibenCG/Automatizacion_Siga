package co.com.AutoSiga.tasks;

import co.com.AutoSiga.models.DatosRol;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.AutoSiga.userinterface.crearrol.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class crear_rol implements Task {

    private final DatosRol datos;

    public crear_rol(DatosRol datos) {
        this.datos = datos;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_PANEL_ROLES),
                Enter.theValue(datos.getNombreDelRol()).into(NOMBRE_ROL),
                Click.on(BTN_REGISTRAR_ROL)
        );

        theActorInTheSpotlight().remember("NOMBRE_ROL_CREADO", datos.getNombreDelRol());
    }

    public static crear_rol conDatos(DatosRol datos) {
        return Instrumented.instanceOf(crear_rol.class).withProperties(datos);
    }
}