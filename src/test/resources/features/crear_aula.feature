#language: es
#author: Edwin1538

Característica: Crear Aula
  Como usuario autenticado
  Quiero crear una nueva aula
  Para que pueda enlazarla luego a una clase

  Antecedentes:
    Dado que el usuario se encuentra en la página de inicio de sesión
    Cuando el usuario ingrese las credenciales válidas
      | Usuario          | Clave    |
      | andres@gmail.com | Contra1234+ |

  @crearAula
  Escenario: Crear un aula
    Cuando crea un aula
      | nombre |
      | Salon  |
    Entonces el aula debe quedar registrada
