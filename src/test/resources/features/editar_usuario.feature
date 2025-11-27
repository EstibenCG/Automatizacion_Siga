#language: es
#author: OctavioGallo

Característica: editar usuario
  Como usuario autenticado
  Quiero editar un usuario (docente o administrador)
  Para actualizar la información del mismo

  Antecedentes:
    Dado que el usuario se encuentra en la página de inicio de sesión
    Cuando el usuario ingrese las credenciales válidas
      | Usuario           | Clave    |
      | estiben@gmail.com | Cont123* |

  @editarUsuario
  Escenario: editar un usuario Docente
    Dado que el usuario ya inició sesión y se encuentra en el panel de usuario
    Cuando edita un usuario
      | correo               | contraseña | rol     |
      | Elpepinillo@mail.com | 12345678   | Docente |
    Entonces el usuario debe quedar actualizado