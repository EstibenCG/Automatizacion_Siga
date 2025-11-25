package co.com.AutoSiga.stepsdefinitions;

import co.com.AutoSiga.models.DatosAsignatura;
import co.com.AutoSiga.questions.ValidacionEditarAsignatura;
import co.com.AutoSiga.tasks.editar_asignatura;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import cucumber.api.DataTable;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;
public class EditarAsignaturaStepDefinitions {

    DatosAsignatura asignatura;

    @Dado("^que el usuario ya inició sesión$")
    public void queElUsuarioYaInicióSesión() {
    }


    @Cuando("^Edita una asignatura$")
    public void editaUnaAsignatura(DataTable table) {
        List<DatosAsignatura> datos = table.asList(DatosAsignatura.class);
        DatosAsignatura asignatura = datos.get(0);
        OnStage.theActorInTheSpotlight().
                attemptsTo(editar_asignatura.conDatos(asignatura)
                );
    }

    @Entonces("^el aula debe quedar editada correctamente$")
    public void elAulaDebeQuedarEditadaCorrectamente() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ValidacionEditarAsignatura.validacionEditarAsignatura(), is(true))
        );
    }

}
