package co.com.AutoSiga.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.AutoSiga.userinterface.crearrol.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidacionCrearRol implements Question<Boolean> {

    public static ValidacionCrearRol validacionCrearRol() {
        return new ValidacionCrearRol();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_PANEL_ROLES, isVisible()).forNoMoreThan(5).seconds()
        );

        String nombreRolCreado = actor.recall("NOMBRE_ROL_CREADO");
        return nombreRolCreado != null && !nombreRolCreado.isEmpty();
    }
}