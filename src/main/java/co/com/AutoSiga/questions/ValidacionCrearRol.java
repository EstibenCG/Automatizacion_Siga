package co.com.AutoSiga.questions;

import co.com.AutoSiga.utils.hooks.SesionVariable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static co.com.AutoSiga.userinterface.crearrol.ROL_EN_LISTA;
import static co.com.AutoSiga.userinterface.crearrol.VERIFICACION;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidacionCrearRol implements Question<Boolean> {
    private static final Logger logger = LoggerFactory.getLogger(ValidacionCrearRol.class);
    private static final String MENSAJE_ESPERADO = "Rol registrado con éxito";

    public static ValidacionCrearRol validacionCrearRol() {
        return new ValidacionCrearRol();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            String rolRegistrado = actor.recall(SesionVariable.ROL.toString());
            logger.info("Validando registro del rol: {}", rolRegistrado);

            actor.attemptsTo(
                    WaitUntil.the(ROL_EN_LISTA(rolRegistrado), isVisible())
                            .forNoMoreThan(8).seconds()
            );
            return ROL_EN_LISTA(rolRegistrado).resolveFor(actor).isVisible();
        } catch (Exception e) {
            logger.error("No se encontró el mensaje de verificación: {}", e.getMessage());
            return false;
        }
    }
}
