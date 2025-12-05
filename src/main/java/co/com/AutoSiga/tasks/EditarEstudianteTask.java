package co.com.AutoSiga.tasks;

import co.com.AutoSiga.models.DatosEstudiante;
import co.com.AutoSiga.models.EditarEstudiante;
import co.com.AutoSiga.userinterface.CrearEstudiantePage;
import co.com.AutoSiga.userinterface.EditarEstudiantePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static co.com.AutoSiga.userinterface.CrearEstudiantePage.ESTUDIANTE_EN_LISTA;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import org.apache.commons.lang3.RandomStringUtils;

public class EditarEstudianteTask implements Task {

    private final DatosEstudiante estudiante;

    public EditarEstudianteTask(DatosEstudiante estudiante) {
        this.estudiante = estudiante;
    }

    String Numero = RandomStringUtils.random(2, false, true);


    public static EditarEstudianteTask inicio(DatosEstudiante estudiante) {
        return instrumented(EditarEstudianteTask.class, estudiante);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("Ingresamos los datos del estudiante: " + estudiante);

        actor.attemptsTo(
                Click.on(EditarEstudiantePage.BTN),
                Enter.theValue(estudiante.getNombre()+ Numero).into(EditarEstudiantePage.NOMBRE),
                Click.on(EditarEstudiantePage.ACTUALIZAR)
        );

        actor.attemptsTo(
                net.serenitybdd.screenplay.waits.WaitUntil.the(
                        ESTUDIANTE_EN_LISTA(estudiante.getNombre()+Numero),
                        net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible()
                ).forNoMoreThan(8).seconds()
        );

        actor.attemptsTo(
                Scroll.to(ESTUDIANTE_EN_LISTA(estudiante.getNombre()+Numero))
        );
    }


    }

