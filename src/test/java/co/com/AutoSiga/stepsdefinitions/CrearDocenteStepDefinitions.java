package co.com.AutoSiga.stepsdefinitions;
import co.com.AutoSiga.models.DatosDocente;
import co.com.AutoSiga.questions.ValidacionCrerDocente;
import co.com.AutoSiga.tasks.crear_docente;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import cucumber.api.DataTable;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;
public class CrearDocenteStepDefinitions {
    DatosDocente Docente;

    @Dado("^inició sesión$")
    public void InicióSesión() {
    }

    @Cuando("^crea un docente$")
    public void creaUndocente(DataTable table) {
        List<DatosDocente> datos = table.asList(DatosDocente.class);
        DatosDocente docente = datos.get(0);
        OnStage.theActorInTheSpotlight().
                attemptsTo(crear_docente.conDatos(docente)
                );
    }

    @Entonces("^docente registrado$")
    public void elDocenteQuedaRegistrado() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ValidacionCrerDocente.validacionCrearDocente(), is(true))
        );
    }

}
