package co.com.AutoSiga.tasks;

import co.com.AutoSiga.userinterface.CrearAsignaturaUI;
import co.com.AutoSiga.questions.ValidacionAsignatura;
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
                // 1) Click en button[5]
                Click.on(CrearAsignaturaUI.BOTON_REGISTRO),
                // 2) Esperar, click en el input del menú y escribir el nombre
                WaitUntil.the(CrearAsignaturaUI.CAMPO_MENU_INPUT, isEnabled()).forNoMoreThan(10).seconds(),
                Click.on(CrearAsignaturaUI.CAMPO_MENU_INPUT),
                Enter.theValue(nombreAsignatura).into(CrearAsignaturaUI.CAMPO_MENU_INPUT),
                // 3) Click en el botón junto al input para confirmar
                WaitUntil.the(CrearAsignaturaUI.CAMPO_MENU_BUTTON, isEnabled()).forNoMoreThan(10).seconds(),
                Click.on(CrearAsignaturaUI.CAMPO_MENU_BUTTON)
        );

        // 4) Validación: la asignatura aparece en el panel
        actor.should(seeThat(ValidacionAsignatura.existeEnElPanel(nombreAsignatura)));
    }

    public static CrearAsignatura conNombre(String nombreAsignatura) {
        return new CrearAsignatura(nombreAsignatura);
    }
}
