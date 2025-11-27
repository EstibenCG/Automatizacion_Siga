package co.com.AutoSiga.tasks;

import co.com.AutoSiga.models.DatosEstudiante;
import co.com.AutoSiga.models.EditarEstudiante;
import co.com.AutoSiga.userinterface.CrearEstudiantePage;
import co.com.AutoSiga.userinterface.EditarEstudiantePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

public class EditarEstudianteTask implements Task {

    private final DatosEstudiante estudiante;

    public EditarEstudianteTask(DatosEstudiante estudiante) {
        this.estudiante = estudiante;
    }

    public static EditarEstudianteTask inicio(DatosEstudiante estudiante) {
        return instrumented(EditarEstudianteTask.class, estudiante);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("Ingresamos los datos del estudiante: " + estudiante);

        actor.attemptsTo(

                Click.on(EditarEstudiantePage.BTN),
                Enter.theValue(estudiante.getNombre()).into(EditarEstudiantePage.NOMBRE),
                Click.on(EditarEstudiantePage.ACTUALIZAR)


        );
        try {
            System.out.printf("se registro exitosamente el estudiante");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    }

