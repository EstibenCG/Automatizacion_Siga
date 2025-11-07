package co.com.AutoSiga.runners;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/crear_usuario.feature",
        glue = {"co.com.AutoSiga.stepsdefinitions", "co.com.AutoSiga.utils.hooks"},
        snippets = SnippetType.CAMELCASE)
public class CrearUsuarioRunner {
}