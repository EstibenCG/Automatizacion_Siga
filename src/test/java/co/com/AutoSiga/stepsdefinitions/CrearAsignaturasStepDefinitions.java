package co.com.AutoSiga.stepsdefinitions;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import co.com.AutoSiga.questions.ValidacionAsignatura;
import co.com.AutoSiga.tasks.CrearAsignatura;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class CrearAsignaturasStepDefinitions {

    private String nombreAsignaturaCreada;

    @Dado("que el usuario ya inició sesión")
    public void queElUsuarioYaInicioSesion() {
        // Aquí puedes abrir la página o autenticar si quieres
    }

    @Cuando("crea una nueva asignatura llamada \"([^\"]*)\"$")
    public void creaUnaNuevaAsignaturaLlamada(String nombreAsignatura) {
        this.nombreAsignaturaCreada = nombreAsignatura;
        OnStage.theActorInTheSpotlight().attemptsTo(
                CrearAsignatura.conNombre(nombreAsignatura)
        );
    }

    @Entonces("la asignatura deberia verse reflejada en en el panel")
    public void laAsignaturaDeberiaVerseReflejadaEnEnElPanel() {
        OnStage.theActorInTheSpotlight().should(
                seeThat("la asignatura aparece en el panel",
                        ValidacionAsignatura.existeEnElPanel(nombreAsignaturaCreada))
        );
    }
}
