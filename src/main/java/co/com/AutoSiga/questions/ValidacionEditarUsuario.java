package co.com.AutoSiga.questions;

import co.com.AutoSiga.utils.hooks.SesionVariable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static co.com.AutoSiga.userinterface.crearrol.ROL_EN_LISTA;
import static co.com.AutoSiga.userinterface.crearusuario.USUARIO_EN_LISTA;
import static co.com.AutoSiga.userinterface.crearusuario.VERIFICACION;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidacionEditarUsuario implements Question<Boolean> {
    private static final Logger logger = LoggerFactory.getLogger(ValidacionEditarUsuario.class);
    private static final String MENSAJE_ESPERADO = "Usuario actualizado correctamente";

    public static ValidacionEditarUsuario validacionEditarUsuario() {
        return new ValidacionEditarUsuario();
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
