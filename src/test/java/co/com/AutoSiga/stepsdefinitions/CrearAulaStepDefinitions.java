package co.com.AutoSiga.stepsdefinitions;

import co.com.AutoSiga.models.DatosAula;
import co.com.AutoSiga.questions.ValidacionCrearAula;
import co.com.AutoSiga.tasks.crear_aula;
import cucumber.api.DataTable;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class CrearAulaStepDefinitions {

    @Cuando("^crea un aula$")
    public void creaUnAula(DataTable table) {
        List<DatosAula> datos = table.asList(DatosAula.class);
        DatosAula aula = datos.get(0);
        OnStage.theActorInTheSpotlight().attemptsTo(
                crear_aula.conDatos(aula)
        );
    }

    @Entonces("^el aula debe quedar registrada$")
    public void elAulaDebeQuedarRegistrada() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ValidacionCrearAula.validacionCrearAula(), is(true))
        );
    }
}
