package co.com.AutoSiga.tasks;

import co.com.AutoSiga.models.DatosAula;
import co.com.AutoSiga.utils.hooks.SesionVariable;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import org.apache.commons.lang3.RandomStringUtils;

import static co.com.AutoSiga.userinterface.crearaula.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class crear_aula implements Task {

    private final DatosAula datos;

    public crear_aula(DatosAula datos) {
        this.datos = datos;
    }

    String Numero = RandomStringUtils.random(2, false, true);

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_MODULO_AULAS),
                Enter.theValue(datos.getNombre() + Numero).into(NOMBRE),
                Click.on(BTN)
        );
        theActorInTheSpotlight().remember(SesionVariable.NOMBRE.toString(), datos.getNombre() + Numero);

        actor.attemptsTo(
                net.serenitybdd.screenplay.waits.WaitUntil.the(
                        AULA_EN_LISTA(datos.getNombre()+Numero),
                        net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible()
                ).forNoMoreThan(8).seconds()
        );

        actor.attemptsTo(
                Scroll.to(AULA_EN_LISTA(datos.getNombre()+Numero))
        );

    }

    public static crear_aula conDatos(DatosAula datos) {
        return Instrumented.instanceOf(crear_aula.class).withProperties(datos);
    }
}
