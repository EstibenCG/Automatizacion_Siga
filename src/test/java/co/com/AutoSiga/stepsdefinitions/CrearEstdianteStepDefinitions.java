package co.com.AutoSiga.stepsdefinitions;


import co.com.AutoSiga.models.DatosEstudiante;
import co.com.AutoSiga.tasks.CrearEstudianteTask;
import cucumber.api.DataTable;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.containsString;
public class CrearEstdianteStepDefinitions {
    @Cuando("^crea un Estudiante$")
    public void creaUnEstudiante(List<DatosEstudiante>datos) {
        DatosEstudiante estudiante = datos.get(0);
        theActorInTheSpotlight().attemptsTo(CrearEstudianteTask.inicio(estudiante));
    }

    @Entonces("^que se puede crear un estudiante$")
    public void queSePuedeCrearUnEstudiante() {
        System.out.printf("que se puede crear");
    }

}
