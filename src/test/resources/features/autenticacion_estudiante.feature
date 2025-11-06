#language: es
  #autor: Maria

Característica: Crear Estudiante
  Como usuario quiero registar un
  Estudiante

  Antecedentes:
    Dado usuario se encuentra en la página de inicio de sesión
    Cuando el usuario ingrese las credenciales válidas
      | Usuario         | Clave    |
      | maria@gmail.com | TEST123* |

  @crearAcudiente
  Escenario: Crear un docente
    Cuando crea un docente
      | nombre | apellido | Curso | Acudiente    |
      | Juan   | Mendez   | 2222  | Ferney Lopez |

    Entonces que se puede crear un estudiante
