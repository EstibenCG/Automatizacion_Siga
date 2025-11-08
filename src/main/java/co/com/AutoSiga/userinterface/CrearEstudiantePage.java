package co.com.AutoSiga.userinterface;


import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
public class CrearEstudiantePage extends PageObject {
    public static Target ACUDIENTE = Target.the("ACUDIENTE").
            located(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/select[1]"));
    public static Target CURSO = Target.the("CURSO").
            located(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/input[2]"));
    public static Target NOMBRE = Target.the("NOMBRE").
            located(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/input[1]"));
    public static Target APELLIDO = Target.the("APELLIDO").
            located(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/input[1]"));

    public static Target BTN = Target.the("BOTON").
            located(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/input[2]"));
    public static final Target VERIFICACION = Target.the("ALERTA DE VERIFICACION").
            located(By.cssSelector(".mensaje-exito"));
}
