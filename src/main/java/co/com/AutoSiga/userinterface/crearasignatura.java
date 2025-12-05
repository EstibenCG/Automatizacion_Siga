package co.com.AutoSiga.userinterface;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class crearasignatura extends PageObject {

    public static final Target BTN_MODULO_ASIGNATURA = Target.the("Botón para entrar al módulo de asignaturas")
            .located(By.xpath("/html/body/div/div/div[1]/button[5]"));

    public static final Target NOMBRE_ASIGNATURA = Target.the("Campo nombre de la asignatura")
            .located(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/input"));

    public static final Target BTN_REGISTRAR_ASIGNATURA = Target.the("Botón de registrar asignatura")
            .located(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/button"));

    public static Target ASIGNATURA_EN_LISTA(String nombre) {
        return Target.the("Asignatura en la lista")
                .located(By.xpath("//table//tr[td[contains(text(),'" + nombre + "')]]"));
    }
}
