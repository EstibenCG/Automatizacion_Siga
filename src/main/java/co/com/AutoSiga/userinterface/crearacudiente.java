package co.com.AutoSiga.userinterface;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class crearacudiente extends PageObject {

    public static Target NOMBRE = Target.the("NOMBRE").located(By.xpath("/html/body/div/div/div[2]/div/div[1]/input[1]"));
    public static Target APELLIDO = Target.the("APELLIDO").located(By.xpath("/html/body/div/div/div[2]/div/div[1]/input[2]"));

    public static Target CORREO = Target.the("CORREO").located(By.xpath("/html/body/div/div/div[2]/div/div[1]/input[3]"));
}
