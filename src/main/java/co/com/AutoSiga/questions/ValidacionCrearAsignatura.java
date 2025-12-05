package co.com.AutoSiga.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static co.com.AutoSiga.userinterface.crearasignatura.ASIGNATURA_EN_LISTA;
import co.com.AutoSiga.utils.hooks.SesionVariable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidacionCrearAsignatura implements Question<Boolean> {

    private static final Logger logger = LoggerFactory.getLogger(ValidacionCrearAsignatura.class);

    public static ValidacionCrearAsignatura validacionCrearAsignatura() {
        return new ValidacionCrearAsignatura();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            String nombreRegistrado = actor.recall(SesionVariable.NOMBRE.toString());
            logger.info("Validando registro de la asignatura: {}", nombreRegistrado);

            actor.attemptsTo(
                    WaitUntil.the(ASIGNATURA_EN_LISTA(nombreRegistrado), isVisible())
                            .forNoMoreThan(8).seconds()
            );

            return ASIGNATURA_EN_LISTA(nombreRegistrado).resolveFor(actor).isVisible();

        } catch (Exception e) {
            logger.error("No se encontró el mensaje de verificación: {}", e.getMessage());
            return false;
        }
    }
}
