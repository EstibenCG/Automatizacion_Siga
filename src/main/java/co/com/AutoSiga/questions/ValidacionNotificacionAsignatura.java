package co.com.AutoSiga.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.openqa.selenium.By;

public class ValidacionNotificacionAsignatura implements Question<Boolean> {

    private static final String MENSAJE_ESPERADO = "Asignatura registrada con éxito";

    public static ValidacionNotificacionAsignatura esExitosa() {
        return new ValidacionNotificacionAsignatura();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            // 📍 Notificación que aparece temporalmente
            By notificacionLocator = By.xpath("//*[@id='root']/div/div[2]/div/div[1]");

            int attempts = 20; // 20 * 500ms = 10 segundos
            for (int i = 0; i < attempts; i++) {
                try {
                    String texto = Text.of(notificacionLocator)
                            .viewedBy(actor)
                            .asString()
                            .trim();

                    // ✅ Si contiene el texto esperado, la validación pasa
                    if (texto.contains(MENSAJE_ESPERADO)) {
                        return true;
                    }
                } catch (Exception ignored) {
                    // La notificación puede no haberse mostrado aún o ya desapareció
                }

                Thread.sleep(500);
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
