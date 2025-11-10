#language: es
#author: Edwin1538

Característica: Crear usuario
  Como usuario autenticado
  Quiero registrar un usuario (docente o administrador)
  Para gestionar el acceso al sistema

  Antecedentes:
    Dado que el usuario se encuentra en la página de inicio de sesión
    Cuando el usuario ingrese las credenciales válidas
      | Usuario           | Clave    |
      | estiben@gmail.com | Cont123* |

  @crearUsuario
  Escenario: Crear un usuario Docente
    Dado que el usuario ya inició sesión y se encuentra en el panel de usuario
    Cuando crea un usuario
      | correo            | contraseña | rol      |
      | Elpepe@mail.com   | 12345678   | Docente  |
    Entonces el usuario debe quedar registrado