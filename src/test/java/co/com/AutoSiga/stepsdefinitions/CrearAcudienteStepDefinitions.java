package co.com.AutoSiga.stepsdefinitions;

import co.com.AutoSiga.models.DatosAcudiente;
import co.com.AutoSiga.questions.ValidacionCrearAcudiente;
import co.com.AutoSiga.tasks.crear_acudiente;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import cucumber.api.DataTable;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class CrearAcudienteStepDefinitions {

    DatosAcudiente acudiente;

    @Dado("^que el usuario ya inició sesión$")
    public void queElUsuarioYaInicióSesión() {
    }

    @Cuando("^crea un acudiente$")
    public void creaUnAcudiente(DataTable table) {
        List<DatosAcudiente> datos = table.asList(DatosAcudiente.class);
        DatosAcudiente acudiente = datos.get(0);
        OnStage.theActorInTheSpotlight().
                attemptsTo(crear_acudiente.conDatos(acudiente)
                );
    }


        @Entonces("^el acudiente debe quedar registrado$")
    public void elAcudienteDebeQuedarRegistrado() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ValidacionCrearAcudiente.validacionCrearAcudiente(), is(true))
        );
    }
}
