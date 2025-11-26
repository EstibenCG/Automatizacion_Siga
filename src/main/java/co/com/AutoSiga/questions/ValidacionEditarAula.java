package co.com.AutoSiga.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static co.com.AutoSiga.userinterface.editaraula.VERIFICACION;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidacionEditarAula implements Question<Boolean> {
    private static final Logger logger = LoggerFactory.getLogger(ValidacionEditarAula.class);
    private static final String MENSAJE_ESPERADO = "Aula actualizada correctamente";

    public static ValidacionEditarAula validacionEditarAula(){
        return new ValidacionEditarAula();
    }
    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            actor.attemptsTo(WaitUntil.the(VERIFICACION, isVisible()).forNoMoreThan(5).seconds());

            String texto = Text.of(VERIFICACION).viewedBy(actor).asString().trim();
            logger.info("Texto encontrado en la alerta de verificación: {}", texto);

            return texto.toLowerCase().contains(MENSAJE_ESPERADO.toLowerCase());
        } catch (Exception e) {
            logger.error("No se encontró el mensaje de verificación: {}", e.getMessage());
            return false;
        }
    }
}