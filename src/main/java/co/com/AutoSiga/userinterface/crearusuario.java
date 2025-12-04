package co.com.AutoSiga.userinterface;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class crearusuario extends PageObject {

    public static Target CORREO = Target.the("CAMPO CORREO").located(By.xpath("//*[@id='root']/div/div[2]/div/div[1]/input[1]"));
    public static Target CONTRASENA = Target.the("CAMPO CONTRASEÑA").located(By.xpath("//*[@id='root']/div/div[2]/div/div[1]/input[2]"));
    public static Target DROPDOWN_ROL = Target.the("DROPDOWN SELECCIONAR ROL").located(By.xpath("//*[@id='root']/div/div[2]/div/div[1]/select"));
    public static Target BTN_REGISTRAR = Target.the("BOTÓN REGISTRAR").located(By.xpath("//*[@id='root']/div/div[2]/div/div[1]/button"));

    public static final Target VERIFICACION = Target.the("Alerta de verificación")
            .located(By.cssSelector(".mensaje-exito"));

    public static Target USUARIO_EN_LISTA(String correo) {return Target.the("Usuario en la lista").located(By.xpath("//table//tr[td[contains(text(),'" + correo + "')]]"));
    }
}