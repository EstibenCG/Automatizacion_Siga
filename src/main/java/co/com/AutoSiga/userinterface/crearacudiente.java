package co.com.AutoSiga.userinterface;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class crearacudiente extends PageObject {

    public static Target BTN_MODULO_ACUDIENTES = Target.the("BOTÓN DEL MÓDULO ACUDIENTES").located(By.xpath("/html/body/div/div/div[1]/button[7]"));
    public static Target NOMBRE = Target.the("NOMBRE").located(By.xpath("/html/body/div/div/div[2]/div/div[1]/input[1]"));
    public static Target APELLIDO = Target.the("APELLIDO").located(By.xpath("/html/body/div/div/div[2]/div/div[1]/input[2]"));
    public static Target CORREO = Target.the("CORREO").located(By.xpath("/html/body/div/div/div[2]/div/div[1]/input[3]"));
    public static Target BTN = Target.the("BOTON").located(By.xpath("/html/body/div/div/div[2]/div/div[1]/button"));

    public static final Target VERIFICACION = Target.the("ALERTA DE VERIFICACION").located(By.cssSelector(".mensaje-exito"));
    public static Target ACUDIENTE_EN_LISTA(String nombre) {return Target.the("Acudiente en la lista").located(By.xpath("//table//tr[td[contains(text(),'" + nombre + "')]]"));
    }
}
