package co.com.AutoSiga.runners.SuiteCrear;

import co.com.AutoSiga.runners.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CrearRolRunner.class,
        CrearUsuarioRunner.class,
        CrearAulaRunner.class,
        CrearAsignaturaRunner.class,
        CrearEstudianteRunner.class,
        CrearAcudienteRunner.class

})
public class SuiteCrear {

}
