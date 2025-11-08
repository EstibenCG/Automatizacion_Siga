package co.com.AutoSiga.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CrearAsignaturaUI {

    public static final Target BOTON_MENU = Target.the("Botón del menú de asignaturas")
            .located(By.xpath("//*[@id='root']/div/div[1]/button[2]"));


    public static final Target BOTON_REGISTRO = Target.the("Botón para registrar asignatura")
            .located(By.xpath("//*[@id=\"root\"]/div/div[1]/button[5]"));

    public static final Target CAMPO_MENU_INPUT = Target.the("Input del menú para escribir nombre de asignatura")
            .located(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/input"));

    public static final Target CAMPO_MENU_BUTTON = Target.the("Botón del menú para confirmar nombre de asignatura")
            .located(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/button"));

    public static final Target CAMPO_NOMBRE = Target.the("Campo nombre de la asignatura")
            .located(By.id("nombreAsignatura")); // reemplaza con el id correcto si es distinto

    public static final Target BOTON_GUARDAR = Target.the("Botón guardar asignatura")
            .located(By.className("boton-asignatura"));

    public static final Target PANEL_ASIGNATURAS = Target.the("Panel de asignaturas")
            .located(By.className("panel-asignaturas"));
}

