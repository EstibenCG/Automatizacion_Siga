package co.com.AutoSiga.questions;

import co.com.AutoSiga.utils.hooks.SesionVariable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static co.com.AutoSiga.userinterface.crearusuario.USUARIO_EN_LISTA;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidacionCrearUsuario implements Question<Boolean> {
    private static final Logger logger = LoggerFactory.getLogger(ValidacionCrearUsuario.class);

    public static ValidacionCrearUsuario validacionCrearUsuario() {
        return new ValidacionCrearUsuario();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            String correoRegistrado = actor.recall(SesionVariable.CORREO.toString());
            logger.info("Validando registro del usuario: {}", correoRegistrado);

            actor.attemptsTo(
                    WaitUntil.the(USUARIO_EN_LISTA(correoRegistrado), isVisible())
                            .forNoMoreThan(8).seconds()
            );
            return USUARIO_EN_LISTA(correoRegistrado).resolveFor(actor).isVisible();
        } catch (Exception e) {
            logger.error("No se encontró el mensaje de verificación: {}", e.getMessage());
            return false;
        }
    }
}
