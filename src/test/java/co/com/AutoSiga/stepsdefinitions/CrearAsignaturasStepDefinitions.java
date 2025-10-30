package co.com.AutoSiga.stepsdefinitions;

import co.com.AutoSiga.questions.ValidacionNotificacionAsignatura;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import co.com.AutoSiga.questions.ValidacionAsignatura;
import co.com.AutoSiga.tasks.CrearAsignatura;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

// Nuevos imports para DataTable
import cucumber.api.DataTable;
import java.util.List;
import java.util.Map;

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

    // Nuevo step para la variante que utiliza una tabla de datos en el feature
    @Cuando("^crea una nueva asignatura$")
    public void creaUnaNuevaAsignatura(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        String nombre = rows.get(0).get("nombre");
        this.nombreAsignaturaCreada = nombre;
        OnStage.theActorInTheSpotlight().attemptsTo(
                CrearAsignatura.conNombre(nombre)
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

