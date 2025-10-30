package co.com.AutoSiga.tasks;

import co.com.AutoSiga.questions.ValidacionNotificacionAsignatura;
import co.com.AutoSiga.userinterface.CrearAsignaturaUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class CrearAsignatura implements Task {

    private final String nombreAsignatura;

    public CrearAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(

                Click.on(CrearAsignaturaUI.BOTON_REGISTRO),
                WaitUntil.the(CrearAsignaturaUI.CAMPO_MENU_INPUT, isEnabled()).forNoMoreThan(10).seconds(),
                Click.on(CrearAsignaturaUI.CAMPO_MENU_INPUT),
                Enter.theValue(nombreAsignatura).into(CrearAsignaturaUI.CAMPO_MENU_INPUT),
                WaitUntil.the(CrearAsignaturaUI.CAMPO_MENU_BUTTON, isEnabled()).forNoMoreThan(10).seconds(),
                Click.on(CrearAsignaturaUI.CAMPO_MENU_BUTTON)
        );
        actor.should(seeThat(ValidacionNotificacionAsignatura.esExitosa()));

    }

    public static CrearAsignatura conNombre(String nombreAsignatura) {
        return new CrearAsignatura(nombreAsignatura);
    }
}
