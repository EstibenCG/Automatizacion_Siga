package co.com.AutoSiga.tasks;

import co.com.AutoSiga.userinterface.InicioSiga;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.Click;
import static co.com.AutoSiga.userinterface.autenticacion.LINK_LOGIN;
public class AbrirPagina implements Task {

    public static AbrirPagina lapagina(){ return Tasks.instrumented(AbrirPagina.class);}

        @Override
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(
                Open.browserOn(new InicioSiga()),
                Click.on(LINK_LOGIN)
        );
    }
}
