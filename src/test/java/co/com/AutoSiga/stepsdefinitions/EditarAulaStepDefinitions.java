package co.com.AutoSiga.stepsdefinitions;

import co.com.AutoSiga.models.DatosAula;
import co.com.AutoSiga.questions.ValidacionEditarAula;
import co.com.AutoSiga.tasks.editar_aula;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import cucumber.api.DataTable;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;
public class EditarAulaStepDefinitions {

    DatosAula aula;

    @Dado("^que el usuario ingresó sus credenciales$")
    public void queElUsuarioYaInicióSesión() {
    }


    @Cuando("^Edita un aula$")
    public void editaUnAula(DataTable table) {
        List<DatosAula> datos = table.asList(DatosAula.class);
        DatosAula aula = datos.get(0);
        OnStage.theActorInTheSpotlight().
                attemptsTo(editar_aula.conDatos(aula)
                );
    }

    @Entonces("^el aula debe quedar editada correctamente$")
    public void elAulaDebeQuedarEditadaCorrectamente() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ValidacionEditarAula.validacionEditarAula(), is(true))
        );
    }

}

