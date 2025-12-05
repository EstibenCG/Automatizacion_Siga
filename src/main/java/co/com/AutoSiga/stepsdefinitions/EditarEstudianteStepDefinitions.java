package co.com.AutoSiga.stepsdefinitions;

import co.com.AutoSiga.models.DatosEstudiante;
import co.com.AutoSiga.tasks.EditarEstudianteTask;
import co.com.AutoSiga.userinterface.EditarEstudiantePage;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actions.Click;

public class EditarEstudianteStepDefinitions {

    @Cuando("^me encuentro en la pagina de rol id$")
    public void meEncuentroEnLaPaginaDeRolId() {

    }

    @Entonces("^le doy click al menu estudiante id$")
    public void leDoyClickAlMenuEstudianteId() {
        OnStage.theActorInTheSpotlight()
                .attemptsTo(
                        Click.on(EditarEstudiantePage.MENU_ESTUDIANTE)
                );
    }

    @Cuando("^que se puede Editar un estudiante$")
    public void queSePuedeEditarUnEstudiante(java.util.List<DatosEstudiante> datos) {

        DatosEstudiante estudiante = datos.get(0);

        OnStage.theActorInTheSpotlight()
                .attemptsTo(
                        EditarEstudianteTask.inicio(estudiante)
                );
    }

    @Entonces("^se valida que se Edito un estudiante$")
    public void seValidaQueSeEditoUnEstudiante() {

    }
}

