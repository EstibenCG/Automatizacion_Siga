package co.com.AutoSiga.stepsdefinitions;

import co.com.AutoSiga.models.DatosRol;
import co.com.AutoSiga.questions.ValidacionCrearRol;
import co.com.AutoSiga.tasks.crear_rol;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import cucumber.api.DataTable;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class CrearRolStepDefinitions {

    @Dado("^que el usuario ya inició sesión y se encuentra en el panel de roles$")
    public void queElUsuarioInicióSesión() {
    }

    @Cuando("^crea un rol$")
    public void creaUnRol(DataTable table) {
        List<DatosRol> datos = table.asList(DatosRol.class);
        DatosRol rol = datos.get(0);
        OnStage.theActorInTheSpotlight().attemptsTo(
                crear_rol.conDatos(rol)
        );
    }

    @Entonces("^el rol debe quedar registrado$")
    public void elRolDebeQuedarRegistrado() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ValidacionCrearRol.validacionCrearRol(), is(true))
        );
    }
}