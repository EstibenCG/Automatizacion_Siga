#language: es
  #autor: Maria

Característica: Crear Estudiante
  Como usuario quiero registar un
  Estudiante

  Antecedentes:
    Dado que el usuario se encuentra en la página de inicio de sesión
    Cuando el usuario ingrese las credenciales válidas
      | Usuario         | Clave     |
      | maria@gmail.com | 123456789 |
    Entonces el sistema debe permitir el acceso y mostrar el panel de administrador

  @crearEstudiante
  Escenario: Crea un Estudiante
    Cuando crea un Estudiante
      | nombre | apellido | Curso | Docente            |
      | Juan   | Mendez   | 2222  | Ferney Lopez |

    Entonces que se puede crear un estudiante
