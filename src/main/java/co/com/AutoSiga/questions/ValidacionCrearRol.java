package co.com.AutoSiga.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.AutoSiga.userinterface.crearrol.BTN_PANEL_ROLES;

public class ValidacionCrearRol implements Question<Boolean> {

    public static ValidacionCrearRol validacionCrearRol() {
        return new ValidacionCrearRol();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            return BTN_PANEL_ROLES.resolveFor(actor).isPresent();
        } catch (Exception e) {
            return false;
        }
    }
}