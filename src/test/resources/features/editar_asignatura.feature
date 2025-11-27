#language: es
#author: Edwin1538


Característica: Editar Asignatura
  Como usuario autenticado
  Quiero editar una asignatura registrada
  Para mantener la informacion actualizada


  Antecedentes:
    Dado que el usuario se encuentra en la página de inicio de sesión
    Cuando el usuario ingrese las credenciales válidas
      | Usuario           | Clave    |
      | estiben@gmail.com | Cont123* |

  @editarAsignatura
  Escenario: Editar una asignatura
    Cuando Edita una asignatura
      | Asignatura |
      | Materia    |
    Entonces la asignatura debe quedar editada correctamente
