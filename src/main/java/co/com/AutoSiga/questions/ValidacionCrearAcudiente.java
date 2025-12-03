package co.com.AutoSiga.questions;

import co.com.AutoSiga.utils.hooks.SesionVariable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static co.com.AutoSiga.userinterface.crearacudiente.ACUDIENTE_EN_LISTA;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidacionCrearAcudiente implements Question<Boolean> {

    private static final Logger logger = LoggerFactory.getLogger(ValidacionCrearAcudiente.class);

    public static ValidacionCrearAcudiente validacionCrearAcudiente() {
        return new ValidacionCrearAcudiente();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            String nombreRegistrado = actor.recall(SesionVariable.NOMBRE.toString());
            logger.info("Validando registro del acudiente: {}", nombreRegistrado);

            actor.attemptsTo(
                    WaitUntil.the(ACUDIENTE_EN_LISTA(nombreRegistrado), isVisible())
                            .forNoMoreThan(8).seconds()
            );

            return ACUDIENTE_EN_LISTA(nombreRegistrado).resolveFor(actor).isVisible();

        } catch (Exception e) {
            logger.error("No se encontró el acudiente en la lista: {}", e.getMessage());
            return false;
        }
    }
}
