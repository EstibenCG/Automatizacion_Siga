package co.com.AutoSiga.tasks;
import co.com.AutoSiga.models.DatosEstudiante;
import co.com.AutoSiga.userinterface.CrearEstudiantePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class CrearEstudianteTask implements Task {
    private final DatosEstudiante datos;

    public CrearEstudianteTask(DatosEstudiante datos) {
        this.datos = datos;
    }
    public static CrearEstudianteTask inicio(DatosEstudiante datos){
        return instrumented(CrearEstudianteTask.class,datos);
    }
    @Override
    public <T extends Actor> void performAs(T actor){
        try {
            actor.attemptsTo(
                    WaitUntil.the(CrearEstudiantePage.NOMBRE,isVisible()).forNoMoreThan(5).seconds(),
                    WaitUntil.the(CrearEstudiantePage.NOMBRE,isClickable()).forNoMoreThan(5).seconds(),

                    Enter.theValue(datos.getNombre()).into(CrearEstudiantePage.NOMBRE)

            );
            Thread.sleep(3000);
            System.out.println("se valido en nombre");

        }
        catch (Exception e){
            System.out.println("error al validar datos del formulario");
        }
    }

}
