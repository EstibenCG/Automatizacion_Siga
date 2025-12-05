package co.com.AutoSiga.questions;

import co.com.AutoSiga.utils.hooks.SesionVariable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static co.com.AutoSiga.userinterface.editaraula.*;
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
            String nombreRegistrado = actor.recall(SesionVariable.NOMBRE.toString());
            logger.info("Validando edición del aula: {}", nombreRegistrado);

            actor.attemptsTo(
                    WaitUntil.the(AULA_EDITADA(nombreRegistrado), isVisible())
                            .forNoMoreThan(8).seconds()
            );
            return AULA_EDITADA(nombreRegistrado).resolveFor(actor).isVisible();
        } catch (Exception e) {
            logger.error("No se encontró el mensaje de verificación: {}", e.getMessage());
            return false;
        }
    }
}