package co.com.AutoSiga.tasks;

import co.com.AutoSiga.models.DatosEstudiante;
import co.com.AutoSiga.userinterface.CrearEstudiantePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.Tasks;
import org.apache.commons.lang3.RandomStringUtils;

import static co.com.AutoSiga.userinterface.CrearEstudiantePage.ESTUDIANTE_EN_LISTA;

public class CrearEstudianteTask implements Task {

    private final DatosEstudiante datos;

    public CrearEstudianteTask(DatosEstudiante datos) {
        this.datos = datos;
    }

    String Numero = RandomStringUtils.random(2, false, true);

    public static CrearEstudianteTask inicio(DatosEstudiante datos) {
        return Tasks.instrumented(CrearEstudianteTask.class, datos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        System.out.println("Ingresamos los datos del estudiante: " + datos);

        actor.attemptsTo(
                Enter.theValue(datos.getNombre()+ Numero).into(CrearEstudiantePage.NOMBRE),
                Enter.theValue(datos.getApellido()).into(CrearEstudiantePage.APELLIDO),


                SelectFromOptions.byValue(datos.getAcudiente()).from(CrearEstudiantePage.ACUDIENTE),
                SelectFromOptions.byValue(datos.getCurso()).from(CrearEstudiantePage.CURSO),


                Click.on(CrearEstudiantePage.BTN)
        );

        actor.attemptsTo(
                net.serenitybdd.screenplay.waits.WaitUntil.the(
                        ESTUDIANTE_EN_LISTA(datos.getNombre()+Numero),
                        net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible()
                ).forNoMoreThan(8).seconds()
        );

        actor.attemptsTo(
                Scroll.to(ESTUDIANTE_EN_LISTA(datos.getNombre()+Numero))
        );

        try {
            System.out.printf("se registro exitosamente el estudiante");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
