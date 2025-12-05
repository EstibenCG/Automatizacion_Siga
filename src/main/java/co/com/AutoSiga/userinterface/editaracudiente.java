package co.com.AutoSiga.userinterface;


import com.openhtmltopdf.css.parser.property.PrimitivePropertyBuilders;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;


public class editaracudiente extends PageObject {


    public static Target BTN_MODULO_ACUDIENTES = Target.the("BOTÓN DEL MÓDULO ACUDIENTES").located(By.xpath("//*[@id=\"root\"]/div/div[1]/button[7]"));
    public static Target BTNEDITAR = Target.the("BOTON").located(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/table/tbody/tr[1]/td[5]/button[1]"));
    public static Target NOMBRE = Target.the("NOMBRE").located(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/input[1]"));
    public static Target APELLIDO = Target.the("APELLIDO").located(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/input[2]"));
    public static Target CORREO = Target.the("CORREO").located(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/input[3]"));
    public static Target BTNACTUALIZAR = Target.the("BOTON").located(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/button"));
    public static final Target VERIFICACION = Target.the("ALERTA DE VERIFICACION").located(By.cssSelector(".mensaje-exito"));
    public static Target ACUDIENTE_EDITADO(String nombre) {return Target.the("Asignatura en la lista").located(By.xpath("//table//tr[td[contains(text(),'" + nombre + "')]]"));
    }
}