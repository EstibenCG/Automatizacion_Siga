package co.com.AutoSiga.tasks;

import co.com.AutoSiga.models.DatosEstudiante;
import co.com.AutoSiga.userinterface.CrearEstudiantePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.Tasks;

public class CrearEstudianteTask implements Task {

    private final DatosEstudiante datos;

    public CrearEstudianteTask(DatosEstudiante datos) {
        this.datos = datos;
    }

    public static CrearEstudianteTask inicio(DatosEstudiante datos) {
        return Tasks.instrumented(CrearEstudianteTask.class, datos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        System.out.println("Ingresamos los datos del estudiante: " + datos);

        actor.attemptsTo(
                Enter.theValue(datos.getNombre()).into(CrearEstudiantePage.NOMBRE),
                Enter.theValue(datos.getApellido()).into(CrearEstudiantePage.APELLIDO),


                SelectFromOptions.byValue(datos.getAcudiente()).from(CrearEstudiantePage.ACUDIENTE),
                SelectFromOptions.byValue(datos.getCurso()).from(CrearEstudiantePage.CURSO),


                Click.on(CrearEstudiantePage.BTN)
        );
        try {
            System.out.printf("se registro exitosamente el estudiante");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
