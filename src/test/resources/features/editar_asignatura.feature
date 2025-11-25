#language: es
#author: Edwin1538


Característica: Editar Aula
  Como usuario autenticado
  Quiero editar un aula registrada
  Para mantener la informacion actualizada


  Antecedentes:
    Dado que el usuario se encuentra en la página de inicio de sesión
    Cuando el usuario ingrese las credenciales válidas
      | Usuario           | Clave    |
      | estiben@gmail.com | Cont123* |

  @crearAula
  Escenario: Editar un aula
    Cuando Edita un aula
      | nombre |
      | Salon  |
    Entonces el aula debe quedar editada correctamente
