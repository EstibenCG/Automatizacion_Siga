package co.com.AutoSiga.stepsdefinitions;

import co.com.AutoSiga.questions.ValidacionNotificacionAsignatura;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import co.com.AutoSiga.tasks.CrearAsignatura;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class CrearAsignaturasStepDefinitions {

    private String nombreAsignaturaCreada;

    @Dado("que el usuario ya inició sesión")
    public void queElUsuarioYaInicioSesion() {
        // Aquí puedes abrir la página o autenticar si quieres
    }

    @Cuando("^crea una nueva asignatura llamada '(.+)'$")
    public void creaUnaNuevaAsignaturaLlamada(String nombreAsignatura) {
        this.nombreAsignaturaCreada = nombreAsignatura;
        OnStage.theActorInTheSpotlight().attemptsTo(
                CrearAsignatura.conNombre(nombreAsignatura)
        );
    }

    @Entonces("debería ver una notificación de éxito por la creación de la asignatura")
    public void deberiaVerUnaNotificacionDeExito() {
        OnStage.theActorInTheSpotlight().should(
                seeThat("la notificación de éxito es visible",
                        ValidacionNotificacionAsignatura.esExitosa())
        );
    }
}

