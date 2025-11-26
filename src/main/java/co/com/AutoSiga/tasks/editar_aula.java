
package co.com.AutoSiga.tasks;

import co.com.AutoSiga.models.DatosAula;
import co.com.AutoSiga.utils.hooks.SesionVariable;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.apache.commons.lang3.RandomStringUtils;

import static co.com.AutoSiga.userinterface.editaraula.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class editar_aula implements Task {

    private final DatosAula datos;

    public editar_aula(DatosAula datos) {
        this.datos = datos;
    }
    String Numero = RandomStringUtils.random(2, false, true);
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_MODULO_AULA),
                Click.on(BTNEDITAR),
                Enter.theValue(datos.getNombre()+Numero).into(NOMBRE),
                Click.on(BTNACTUALIZAR)
        );
        theActorInTheSpotlight().remember(SesionVariable.NOMBRE.toString(), datos.getNombre() +Numero);
    }

    public static editar_aula conDatos(DatosAula datos) {
        return Instrumented.instanceOf(editar_aula.class).withProperties(datos);
    }
}