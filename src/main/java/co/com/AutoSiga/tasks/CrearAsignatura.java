package co.com.AutoSiga.tasks;

import co.com.AutoSiga.models.DatosAsignatura;
import co.com.AutoSiga.utils.hooks.SesionVariable;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import org.apache.commons.lang3.RandomStringUtils;

import static co.com.AutoSiga.userinterface.crearasignatura.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CrearAsignatura implements Task {

    private final String nombreAsignatura;

    public CrearAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    String sufijo = RandomStringUtils.random(2, false, true);

    @Override
    public <T extends Actor> void performAs(T actor) {

        String nombreFinal = nombreAsignatura + sufijo;

        actor.attemptsTo(
                Click.on(BTN_MODULO_ASIGNATURA),
                Enter.theValue(nombreFinal).into(NOMBRE_ASIGNATURA),
                Click.on(BTN_REGISTRAR_ASIGNATURA)
        );

        // Guardamos en la sesión para validación posterior
        theActorInTheSpotlight().remember(SesionVariable.NOMBRE.toString(), nombreFinal);

        actor.attemptsTo(
                net.serenitybdd.screenplay.waits.WaitUntil.the(
                        ASIGNATURA_EN_LISTA(nombreFinal),
                        net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible()
                ).forNoMoreThan(8).seconds()
        );

        actor.attemptsTo(
                Scroll.to(ASIGNATURA_EN_LISTA(nombreFinal))
        );
    }

    public static CrearAsignatura conNombre(String nombre) {
        return Instrumented.instanceOf(CrearAsignatura.class).withProperties(nombre);
    }
}
