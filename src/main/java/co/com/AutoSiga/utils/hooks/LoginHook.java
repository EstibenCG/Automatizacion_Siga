package co.com.AutoSiga.utils.hooks;

import co.com.AutoSiga.models.CredencialesInicioSesion;
import co.com.AutoSiga.tasks.AbrirPagina;
import co.com.AutoSiga.tasks.Autenticarse;
import cucumber.api.java.Before;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class LoginHook {

    @Before("@login")
    public void loginBeforeScenario() {
        setTheStage(new OnlineCast());

        String user = Objects.requireNonNullElse(System.getenv("TMDB_USER"), "estiben@gmail.com");
        String pass = Objects.requireNonNullElse(System.getenv("TMDB_PASS"), "Cont123*");

        CredencialesInicioSesion c = new CredencialesInicioSesion();
        c.setUsuario(user);
        c.setClave(pass);
        List<CredencialesInicioSesion> credenciales = Collections.singletonList(c);

        theActorCalled("Usuario").wasAbleTo(
                AbrirPagina.lapagina(),
                Autenticarse.aute(credenciales)
        );
    }
}
