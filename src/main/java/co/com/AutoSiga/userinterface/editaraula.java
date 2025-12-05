package co.com.AutoSiga.userinterface;
import com.openhtmltopdf.css.parser.property.PrimitivePropertyBuilders;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class editaraula extends PageObject {
    public static Target BTN_MODULO_AULA = Target.the("BOTÓN DEL MÓDULO ASIGNATURAS").located(By.xpath("/html/body/div/div/div[1]/button[4]"));
    public static Target BTNEDITAR = Target.the("BOTON").located(By.xpath("/html/body/div/div/div[2]/div/div/table/tbody/tr[1]/td[3]/button[1]"));

    public static Target NOMBRE = Target.the("NOMBRE").located(By.xpath("/html/body/div/div/div[2]/div/form/div/div/input"));
    public static Target BTNACTUALIZAR = Target.the("BOTON").located(By.xpath("/html/body/div/div/div[2]/div/form/div/button[1]"));

    public static final Target VERIFICACION = Target.the("ALERTA DE VERIFICACION").located(By.cssSelector(".mensaje-exito"));
    public static Target AULA_EDITADA(String nombre) {return Target.the("Acudiente en la lista").located(By.xpath("//table//tr[td[contains(text(),'" + nombre + "')]]"));
    }
    }

