package co.com.AutoSiga.userinterface;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class autenticacion extends PageObject{

    public static Target INPUT_USUARIO = Target.the("Ingreso del Usuario").located(By.id("form2Example11"));
    public static Target INPUT_CLAVE= Target.the("Ingreso del password").located(By.id("form2Example22"));
    public static Target BTN_INICIOSESION= Target.the("Clic boton inicio sesion").located(By.xpath("//*[@id=\"root\"]/section/div/div/div/div/div/div[1]/div/form/div[3]/button"));

    public static Target MENSAJE_LOGIN = Target.the("mensaje de login").locatedBy("//*[@id=\"root\"]/div/div[2]/div/h2");

}
