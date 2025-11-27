package co.com.AutoSiga.runners.SuiteEditar;

import co.com.AutoSiga.runners.EditarAsignaturaRunner;
import co.com.AutoSiga.runners.EditarAulaRunner;
import co.com.AutoSiga.runners.EditarEstudianteRunner;
import co.com.AutoSiga.runners.EditarUsuarioRunner;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        EditarUsuarioRunner.class,
        EditarAulaRunner.class,
        EditarAsignaturaRunner.class,
        EditarEstudianteRunner.class
})
public class SuiteEditar {

}
