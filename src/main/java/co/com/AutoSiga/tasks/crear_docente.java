package co.com.AutoSiga.tasks;

import co.com.AutoSiga.models.DatosDocente;
import co.com.AutoSiga.utils.hooks.SesionVariable;
import co.com.AutoSiga.userinterface.CrearDocente;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.apache.commons.lang3.RandomStringUtils;

import static co.com.AutoSiga.userinterface.CrearDocente.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
public class crear_docente implements Task {
    private final DatosDocente datos;

    public crear_docente(DatosDocente datos) {
        this.datos = datos;
    }

    String Numero = RandomStringUtils.random(2, false, true);

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_MODULO_Docente),
                Enter.theValue(datos.getnombre() + Numero).into(NOMBRE),
                Enter.theValue(datos.getapellido() + Numero).into(APELLIDO),
                Click.on(BTN)
        );

        theActorInTheSpotlight().remember(SesionVariable.NOMBRE.toString(), datos.getnombre() + Numero);
    }

    public static crear_docente conDatos(DatosDocente datos) {
        return Instrumented.instanceOf(crear_docente.class).withProperties(datos);
    }
}



