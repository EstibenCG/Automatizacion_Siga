# language: es
# autor: Maria

Característica: Editar Estudiante
  Como usuario quiero editar un estudiante
  que esta en el sistema

  Antecedentes:
    Dado que el usuario se encuentra en la página de inicio de sesión
    Cuando el usuario ingrese las credenciales válidas
      | Usuario         | Clave     |
      | maria@gmail.com | Maria2023 |
    Entonces el sistema debe permitir el acceso y mostrar el panel de administrador

  @EditarEstudiante
  Escenario: Editar un Estudiante
    Cuando me encuentro en la pagina de rol id
    Entonces le doy click al menu estudiante id
   Cuando que se puede Editar un estudiante
     | Nombre | apellido | curso | acudiente |
     | Carlos | Mendez   | 3     | 3         |
    Entonces se valida que se Edito un estudiante
