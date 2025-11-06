#language: es
#author: Maria
Característica: Crear docente
  Como usuario quiero registar un
  Nuevo docente

  Antecedentes:
    Dado que el usuario se encuentra en la página de inicio de sesión
    Cuando el usuario ingrese las credenciales válidas
      | Usuario         | Clave    |
      | maria@gmail.com | TEST123* |

  @crearDocente
  Escenario: Crear un docente
    Cuando crea un docente
      | nombre | apellido |
      | Juan   |Mendez    |

    Entonces Docente puede registrar a un estudiante
