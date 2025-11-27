package co.com.AutoSiga.runners.SuiteEditar;

import co.com.AutoSiga.runners.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        EditarUsuarioRunner.class,
        EditarAulaRunner.class,
        EditarAsignaturaRunner.class,
        EditarEstudianteRunner.class,
        EditarAcudienteRunner.class
})
public class SuiteEditar {

}
