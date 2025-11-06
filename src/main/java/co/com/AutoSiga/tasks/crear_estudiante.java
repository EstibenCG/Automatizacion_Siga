package co.com.AutoSiga.tasks;
import co.com.AutoSiga.models.DatosEstudiante;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.apache.commons.lang3.RandomStringUtils;

import static co.com.AutoSiga.userinterface.CrearEstudiante.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
class crear_estudiante implements Task {
    private final DatosEstudiante datos;

    public crear_estudiante(DatosEstudiante datos) {
        this.datos = datos;
    }

    String Numero = RandomStringUtils.random(2, false, true);

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN),
                Enter.theValue(datos.getNombre() + Numero).into(NOMBRE),
                Click.on(BTN)
        );
        theActorInTheSpotlight().remember(co.com.AutoSiga.utils.hooks.SesionVariable.NOMBRE.toString(), datos.getNombre() + Numero);
    }

    public static crear_estudiante conDatos(DatosEstudiante datos) {
        return Instrumented.instanceOf(crear_estudiante.class).withProperties(datos);
    }
}


