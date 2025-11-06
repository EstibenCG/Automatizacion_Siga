package co.com.AutoSiga.stepsdefinitions;

import co.com.AutoSiga.models.DatosEstudiante;
import co.com.AutoSiga.questions.ValidacionCrearEstudiante;
import co.com.AutoSiga.userinterface.CrearEstudiante;
import cucumber.api.DataTable;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;
public class CrearEstudianteStepDefinitions {

    @Cuando("^crea un Estudiante$")
    public void creaEstudiante(DataTable table) {
        List<DatosEstudiante> datos = table.asList(DatosEstudiante.class);
        DatosEstudiante estudiante = datos.get(0);
        OnStage.theActorInTheSpotlight().attemptsTo(
                creaEstudiante().conDatos(estudiante)
        );
    }

    private Performable conDatos(DatosEstudiante estudiante) {
        return null;
    }

    private CrearEstudianteStepDefinitions creaEstudiante() {
        return null;
    }

    @Entonces("^registro de Estudiante$")
    public void registrodeEstudiante() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ValidacionCrearEstudiante.validacionCrearEstudiante(), is(true))
        );
    }
}
