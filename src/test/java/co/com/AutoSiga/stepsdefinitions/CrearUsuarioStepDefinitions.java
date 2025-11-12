package co.com.AutoSiga.stepsdefinitions;

import co.com.AutoSiga.models.DatosUsuario;
import co.com.AutoSiga.questions.ValidacionCrearUsuario;
import co.com.AutoSiga.tasks.crear_usuario;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import cucumber.api.DataTable;
import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class CrearUsuarioStepDefinitions {

    DatosUsuario usuario;

    @Dado("^que el usuario ya esta logueado$")
    public void queElUsuarioInicióSesiónYSeEncuentraEnElPanelDeUsuario() {
    }

    @Cuando("^crea un usuario$")
    public void creaUnUsuario(DataTable table) {
        List<DatosUsuario> datos = table.asList(DatosUsuario.class);
        DatosUsuario usuario = datos.get(0);
        OnStage.theActorInTheSpotlight().
                attemptsTo(crear_usuario.conDatos(usuario)
                );
    }


    @Entonces("^el usuario debe quedar registrado$")
    public void elUsuarioDebeQuedarRegistrado() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ValidacionCrearUsuario.validacionCrearUsuario(), is(true))
        );
    }
}