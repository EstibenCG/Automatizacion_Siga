package co.com.AutoSiga.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static co.com.AutoSiga.userinterface.crearaula.AULA_EN_LISTA;
import co.com.AutoSiga.utils.hooks.SesionVariable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidacionCrearAula implements Question<Boolean> {
    private static final Logger logger = LoggerFactory.getLogger(ValidacionCrearAula.class);

    public static ValidacionCrearAula validacionCrearAula() {
        return new ValidacionCrearAula();
    }
    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            String nombreRegistrado = actor.recall(SesionVariable.NOMBRE.toString());
            logger.info("Validando registro del acudiente: {}", nombreRegistrado);

            actor.attemptsTo(
                    WaitUntil.the(AULA_EN_LISTA(nombreRegistrado), isVisible())
                            .forNoMoreThan(8).seconds()
            );
            return AULA_EN_LISTA(nombreRegistrado).resolveFor(actor).isVisible();
        }catch(Exception e) {
            logger.error("No se encontró el mensaje de verificación: {}", e.getMessage());
            return false;
        }
    }
}