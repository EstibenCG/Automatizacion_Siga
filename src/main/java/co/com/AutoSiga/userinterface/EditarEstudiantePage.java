package co.com.AutoSiga.userinterface;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;


public class EditarEstudiantePage {
    public static final Target NOMBRE = Target.the("campo nombre")
            .located(By.name("nombre"));

    public static final Target APELLIDO = Target.the("campo apellido")
            .located(By.name("apellido"));

    public static final Target CURSO = Target.the("selector curso")
            .located(By.name("curso_id"));

    public static final Target ACUDIENTE = Target.the("selector acudiente")
            .located(By.name("acudiente_id"));

    public static final Target BTN = Target.the("boton editar")
            .located(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/table/tbody/tr[1]/td[6]/button[1]"));

    public static Target MENU_ESTUDIANTE = Target.the("BOTON DEL MENU PARA IR A ESTUDIANTE").
            located(By.xpath("//*[@id=\"root\"]/div/div[1]/button[9]"));
    public static Target ACTUALIZAR = Target.the("BOTON ACTUALIZAR").
            located(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/button"));

    public static Target ESTUDIANTE_EDITADO(String nombre) {
        return Target.the("Estudiante en la lista").located(By.xpath("//table//tr[td[contains(text(),'" + nombre + "')]]"));
    }

    }

