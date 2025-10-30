package co.com.AutoSiga.stepsdefinitions;

import co.com.AutoSiga.models.CredencialesInicioSesion;
import co.com.AutoSiga.questions.ValidacionLogin;
import co.com.AutoSiga.tasks.AbrirPagina;
import co.com.AutoSiga.tasks.Autenticarse;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class AutenticacionStepDefinitions {

    @Dado("^que el usuario se encuentra en la página de inicio de sesión$")
    public void queElUsuarioSeEncuentraEnLaPaginaDeInicioDeSesion() {
        theActorInTheSpotlight().wasAbleTo(AbrirPagina.lapagina());
    }

    @Cuando("^el usuario ingrese las credenciales válidas$")
    public void elUsuarioIngreseLasCredencialesValidas(List<CredencialesInicioSesion> credenciales) {
        theActorInTheSpotlight().attemptsTo(Autenticarse.aute(credenciales));
    }

    @Entonces("^el sistema debe permitir el acceso y mostrar el panel de administrador$")
    public void elSistemaDebePermitirElAccesoYMostrarElPanelDeAdministrador() {
        theActorInTheSpotlight().should(seeThat(ValidacionLogin.validacionLogin()));
    }
}
