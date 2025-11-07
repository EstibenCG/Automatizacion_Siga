package co.com.AutoSiga.userinterface;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class crearaula extends PageObject {

    public static final Target BTN_MODULO_AULAS = Target.the("Botón para entrar al módulo de aulas")
            .located(By.xpath("/html/body/div/div/div[1]/button[4]"));

    public static final Target NOMBRE = Target.the("Campo de nombre del aula")
            .located(By.xpath("/html/body/div/div/div[2]/div/form/div/div/input"));

    public static final Target BTN = Target.the("Botón de registrar aula")
            .located(By.xpath("/html/body/div/div/div[2]/div/form/div/button"));

    public static final Target VERIFICACION = Target.the("Alerta de verificación")
            .located(By.cssSelector(".mensaje-exito"));
}
