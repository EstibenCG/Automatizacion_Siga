package co.com.AutoSiga.userinterface;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class editarusuario extends PageObject {

    public static Target BTN_EDITAR_USUARIO = Target.the("BOTÓN EDITAR USUARIO").located(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/table/tbody/tr[43]/td[4]/button[1]"));
    public static Target CORREO = Target.the("CAMPO CORREO").located(By.xpath("//*[@id='root']/div/div[2]/div/div[1]/input[1]"));
    public static Target CONTRASENA = Target.the("CAMPO CONTRASEÑA").located(By.xpath("//*[@id='root']/div/div[2]/div/div[1]/input[2]"));
    public static Target DROPDOWN_ROL = Target.the("DROPDOWN SELECCIONAR ROL").located(By.xpath("//*[@id='root']/div/div[2]/div/div[1]/select"));
    public static Target BTN_ACTUALIZAR = Target.the("BOTÓN REGISTRAR").located(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/button[1]"));

    public static final Target VERIFICACION = Target.the("Alerta de verificación")
            .located(By.cssSelector(".mensaje-exito"));
}