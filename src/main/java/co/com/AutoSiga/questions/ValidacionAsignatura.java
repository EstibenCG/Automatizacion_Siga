package co.com.AutoSiga.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import co.com.AutoSiga.userinterface.CrearAsignaturaUI;

public class ValidacionAsignatura implements Question<Boolean> {

    private final String nombreAsignatura;

    public ValidacionAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    public static ValidacionAsignatura existeEnElPanel(String nombreAsignatura) {
        return new ValidacionAsignatura(nombreAsignatura);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String textoPanel = Text.of(CrearAsignaturaUI.PANEL_ASIGNATURAS)
                .viewedBy(actor)
                .asString();
        return textoPanel.contains(nombreAsignatura);
    }
}
