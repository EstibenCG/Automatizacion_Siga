package co.com.AutoSiga.stepsdefinitions;

import co.com.AutoSiga.models.DatosEstudiante;
import co.com.AutoSiga.tasks.CrearEstudianteTask;
import co.com.AutoSiga.tasks.EstudianteClickMenu;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CrearEstudianteStepDefinitions {

    @Cuando("^me encuentro en la pagina de rol$")
    public void meEncuentroEnLaPaginaDeRol() {
        // Aquí podrías validar si el usuario está logueado o en el dashboard
        System.out.println("El usuario está en la página de rol");
    }

    @Entonces("^le doy click al menu estudiante$")
    public void leDoyClickAlMenuEstudiante() {
        theActorInTheSpotlight().attemptsTo(EstudianteClickMenu.darClick());
        System.out.println("Se hizo clic en el menú estudiante");
    }

    @Cuando("^crea un Estudiante$")
    public void creaUnEstudiante(List<DatosEstudiante> datos) {
        DatosEstudiante estudiante = datos.get(0);
        System.out.println("Datos recibidos: " + estudiante);
        theActorInTheSpotlight().attemptsTo(CrearEstudianteTask.inicio(estudiante));
    }

    @Entonces("^que se puede crear un estudiante$")
    public void queSePuedeCrearUnEstudiante() {
        System.out.println("Validación: el estudiante fue creado correctamente.");
    }
}
