package co.com.AutoSiga.stepsdefinitions;
import co.com.AutoSiga.models.DatosEstudiante;
import co.com.AutoSiga.models.EditarEstudiante;
import co.com.AutoSiga.tasks.CrearEstudianteTask;
import co.com.AutoSiga.tasks.EditarEstudianteTask;
import co.com.AutoSiga.tasks.EstudianteClickMenu;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
public class EditarEstudianteStepDefinitions {

    @Cuando("^me encuentro en la pagina de rol id$")
    public void meEncuentroEnLaPaginaDeRolId() {
        // Aquí podrías validar si el usuario está logueado o en el dashboard
        System.out.println("El usuario está en la página de rol");
    }
    @Entonces("^le doy click al menu estudiante id$")
    public void leDoyClickAlMenuEstudianteId() {
        theActorInTheSpotlight().attemptsTo(EstudianteClickMenu.darClick());
        System.out.println("Se hizo clic en el menú estudiante");
    }


    @Cuando("^que se puede Editar un estudiante$")
    public void queSePuedeEditarUnEstudiante(List<DatosEstudiante> datos) {
        DatosEstudiante estudiante = datos.get(0);
        System.out.println("Datos recibidos: " + estudiante);
        theActorInTheSpotlight().attemptsTo(EditarEstudianteTask.inicio(estudiante));

    }
    @Entonces("^se valida que se Edito un estudiante$")
    public void validarEdicionEstudiante() {
        System.out.println("Se validó que el estudiante fue editado correctamente.");
    }



}

