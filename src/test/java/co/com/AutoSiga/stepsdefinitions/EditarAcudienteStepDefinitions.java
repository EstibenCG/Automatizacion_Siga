package co.com.AutoSiga.stepsdefinitions;

import co.com.AutoSiga.models.DatosAcudiente;
import co.com.AutoSiga.questions.ValidacionEditarAcudiente;
import co.com.AutoSiga.tasks.editar_acudiente;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import cucumber.api.DataTable;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class EditarAcudienteStepDefinitions {

    DatosAcudiente acudiente;

    @Dado("^que el usuario ya se logeó$")
    public void queElUsuarioYaInicióSesión() {
    }


    @Cuando("^edita un acudiente$")
    public void editaUnAcudiente(DataTable table) {
        List<DatosAcudiente> datos = table.asList(DatosAcudiente.class);
        DatosAcudiente acudiente = datos.get(0);
        OnStage.theActorInTheSpotlight().
                attemptsTo(editar_acudiente.conDatos(acudiente)
                );
    }

    @Entonces("^el acudiente debe quedar editado correctamente$")
    public void elAcudienteDebeQuedarEditadoCorrectamente() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ValidacionEditarAcudiente.validacionEditarAcudiente(), is(true))
        );
    }

}