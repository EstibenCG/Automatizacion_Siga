package co.com.AutoSiga.tasks;

import co.com.AutoSiga.userinterface.CrearAsignaturaUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class CrearAsignatura implements Task {

    private final String nombreAsignatura;

    public CrearAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CrearAsignaturaUI.BOTON_MENU),
                Click.on(CrearAsignaturaUI.BOTON_REGISTRO),
                Enter.theValue(nombreAsignatura).into(CrearAsignaturaUI.CAMPO_NOMBRE),
                Click.on(CrearAsignaturaUI.BOTON_GUARDAR)
        );
    }

    public static CrearAsignatura conNombre(String nombreAsignatura) {
        return new CrearAsignatura(nombreAsignatura);
    }
}
