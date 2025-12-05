package co.com.AutoSiga.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import co.com.AutoSiga.utils.hooks.SesionVariable;
import static co.com.AutoSiga.userinterface.editaracudiente.*;

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
            String nombreRegistrado = actor.recall(SesionVariable.NOMBRE.toString());
            logger.info("Validando edición de la asignatura: {}", nombreRegistrado);

            actor.attemptsTo(
                    WaitUntil.the(ACUDIENTE_EDITADO(nombreRegistrado), isVisible())
                            .forNoMoreThan(8).seconds()
            );
            return ACUDIENTE_EDITADO(nombreRegistrado).resolveFor(actor).isVisible();
        } catch (Exception e) {
            logger.error("No se encontró el mensaje de verificación: {}", e.getMessage());
            return false;
        }
    }
}