package co.com.AutoSiga.tasks;

import co.com.AutoSiga.models.DatosEstudiante;
import co.com.AutoSiga.userinterface.EditarEstudiantePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static net.serenitybdd.screenplay.Tasks.instrumented;

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

        actor.attemptsTo(
                WaitUntil.the(
                        EditarEstudiantePage.ESTUDIANTE_EDITADO(
                                estudiante.getNombre()
                        ),
                        WebElementStateMatchers.isVisible()
                ).forNoMoreThan(7).seconds()
        );


        WebElement element = EditarEstudiantePage.ESTUDIANTE_EDITADO(
                estudiante.getNombre()
        ).resolveFor(actor);

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        ((JavascriptExecutor) driver).executeScript("...");


        System.out.println("Scroll ejecutado correctamente");






        try {
            System.out.println("Se registró exitosamente el estudiante");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
