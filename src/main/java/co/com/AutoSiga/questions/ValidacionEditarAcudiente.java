package co.com.AutoSiga.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static co.com.AutoSiga.userinterface.editaracudiente.VERIFICACION;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidacionEditarAcudiente implements Question<Boolean> {
    private static final Logger logger = LoggerFactory.getLogger(ValidacionEditarAcudiente.class);
    private static final String MENSAJE_ESPERADO = "Acudiente actualizado correctamente";

    public static ValidacionEditarAcudiente validacionEditarAcudiente(){
        return new ValidacionEditarAcudiente();
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