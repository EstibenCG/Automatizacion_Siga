package co.com.AutoSiga.tasks;

import co.com.AutoSiga.userinterface.CrearEstudiantePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.containsString;
import static net.serenitybdd.screenplay.Tasks.instrumented;
public class EstudianteClickMenu implements Task {
    public static EstudianteClickMenu darClick(){
        return instrumented(EstudianteClickMenu.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor){
        try {
            actor.attemptsTo(
                    WaitUntil.the(CrearEstudiantePage.MENU_ESTUDIANTE,isVisible()).forNoMoreThan(5).seconds(),
                    WaitUntil.the(CrearEstudiantePage.MENU_ESTUDIANTE,isClickable()).forNoMoreThan(5).seconds(),

                    Click.on(CrearEstudiantePage.MENU_ESTUDIANTE)


            );
            Thread.sleep(9000);
            System.out.println("se dio click en menu");

        }
        catch (Exception e){
            System.out.println("no se dio click");
        }
    }

}


