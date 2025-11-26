package co.com.AutoSiga.stepsdefinitions;

import co.com.AutoSiga.models.DatosUsuario;
import co.com.AutoSiga.questions.ValidacionEditarUsuario;
import co.com.AutoSiga.tasks.editar_usuario;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import cucumber.api.DataTable;
import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class EditarUsuarioStepDefinitions {

    DatosUsuario usuario;

    @Dado("^que el usuario ya esta logueado para editar$")
    public void queElUsuarioInicióSesiónYSeEncuentraEnElPanelDeUsuarioParaEditar() {
    }

    @Cuando("^edita un usuario$")
    public void editarUnUsuario(DataTable table) {
        List<DatosUsuario> datos = table.asList(DatosUsuario.class);
        DatosUsuario usuario = datos.get(0);
        OnStage.theActorInTheSpotlight().
                attemptsTo(editar_usuario.conDatos(usuario)
                );
    }


    @Entonces("^el usuario debe quedar actualizado$")
    public void elUsuarioDebeQuedarActualizado() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ValidacionEditarUsuario.validacionEditarUsuario(), is(true))
        );
    }
}