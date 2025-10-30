package co.com.AutoSiga.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import co.com.AutoSiga.userinterface.CrearAsignaturaUI;
import org.openqa.selenium.By;

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
        try {
            // Buscamos dinámicamente la celda en la tabla que contenga exactamente el nombre
            String xpathExact = String.format("//*[@id=\"root\"]//table//tbody//td[normalize-space()=\"%s\"]", nombreAsignatura);
            String xpathContains = String.format("//*[@id=\"root\"]//table//tbody//td[contains(normalize-space(.),\"%s\")]", nombreAsignatura);

            int attempts = 30; // 30 * 500ms = 15s
            for (int i = 0; i < attempts; i++) {
                try {
                    String texto = Text.of(By.xpath(xpathExact)).viewedBy(actor).asString().trim();
                    if (!texto.isEmpty()) {
                        return true;
                    }
                } catch (Exception e) {
                    // ignore, intentamos contains después
                }

                try {
                    String texto2 = Text.of(By.xpath(xpathContains)).viewedBy(actor).asString().trim();
                    if (!texto2.isEmpty()) {
                        return true;
                    }
                } catch (Exception e) {
                    // ignore
                }

                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }

            // Fallback final: buscar en el panel completo
            String textoPanel = Text.of(CrearAsignaturaUI.PANEL_ASIGNATURAS)
                    .viewedBy(actor)
                    .asString();
            return textoPanel.contains(nombreAsignatura);

        } catch (Exception e) {
            // Si falla la búsqueda, retornamos false
            return false;
        }
    }
}
