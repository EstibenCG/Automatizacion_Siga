# language: es
# autor: Maria

Característica: Crear Estudiante
  Como usuario quiero registrar un estudiante
  para que aparezca en el sistema

  Antecedentes:
    Dado que el usuario se encuentra en la página de inicio de sesión
    Cuando el usuario ingrese las credenciales válidas
      | Usuario           | Clave    |
      | estiben@gmail.com | Cont123* |
    Entonces el sistema debe permitir el acceso y mostrar el panel de administrador

  @crearEstudiante
  Escenario: Crea un Estudiante
    Cuando me encuentro en la pagina de rol
    Entonces le doy click al menu estudiante
    Cuando crea un Estudiante
      | nombre | apellido | curso | acudiente |
      | Juan   | Mendez   | 3     | 3         |
    Entonces que se puede crear un estudiante
