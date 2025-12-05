package co.com.AutoSiga.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class crearrol extends PageObject {

    public static Target BTN_PANEL_ROLES = Target.the("BOTÓN PANEL ROLES").located(By.xpath("//*[@id='root']/div/div[1]/button[1]"));
    public static Target NOMBRE_ROL = Target.the("CAMPO NOMBRE ROL").located(By.xpath("//*[@id='root']/div/div[2]/div/div[1]/input[1]"));
    public static Target BTN_REGISTRAR_ROL = Target.the("BOTÓN REGISTRAR ROL").located(By.xpath("//*[@id='root']/div/div[2]/div/div[1]/button"));

    public static final Target VERIFICACION = Target.the("Alerta de verificación")
            .located(net.serenitybdd.core.annotations.findby.By.cssSelector(".mensaje-exito"));
    public static Target ROL_EN_LISTA(String nombre) {
        return Target.the("ROL en la lista").located(By.xpath("//table//tr[td[contains(text(),'" + nombre + "')]]"));
    }
}