package co.com.AutoSiga.questions;

import co.com.AutoSiga.utils.hooks.SesionVariable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static co.com.AutoSiga.userinterface.editarasignatura.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidacionEditarAsignatura implements Question<Boolean> {
    private static final Logger logger = LoggerFactory.getLogger(ValidacionEditarAsignatura.class);
    private static final String MENSAJE_ESPERADO = "Asignatura actualizada con éxito";

    public static ValidacionEditarAsignatura validacionEditarAsignatura(){
        return new ValidacionEditarAsignatura();
    }
    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            String nombreRegistrado = actor.recall(SesionVariable.NOMBRE.toString());
            logger.info("Validando edición de la asignatura: {}", nombreRegistrado);

            actor.attemptsTo(
                    WaitUntil.the(ASIGNATURA_EDITADA(nombreRegistrado), isVisible())
                            .forNoMoreThan(8).seconds()
            );
            return ASIGNATURA_EDITADA(nombreRegistrado).resolveFor(actor).isVisible();
        } catch (Exception e) {
            logger.error("No se encontró el mensaje de verificación: {}", e.getMessage());
            return false;
        }
    }
}