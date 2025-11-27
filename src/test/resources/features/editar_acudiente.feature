#language: es
#author: EstibenCG

Característica: Editar Acudiente
  Como usuario autenticado
  Quiero editar un acudiente registrado
  Para mantener la información actualizada

  Antecedentes:
    Dado que el usuario se encuentra en la página de inicio de sesión
    Cuando el usuario ingrese las credenciales válidas
      | Usuario           | Clave    |
      | estiben@gmail.com | Cont123* |

  @editarAcudiente
  Escenario: Editar un acudiente
    Cuando edita un acudiente
      | Nombre | Apellido | Correo            |
      | Juan   | Perez    | juan@example.com  |
    Entonces el acudiente debe quedar editado correctamente