#language: es
#author: Estiben

Característica: Crear asignatura en la pagina
  Como usuario autenticado
  Quiero crear un nueva asignatura
  que usare mas adelante

  Antecedentes:
    Dado que el usuario se encuentra en la página de inicio de sesión
    Cuando el usuario ingrese las credenciales válidas
      | Usuario           | Clave    |
      | estiben@gmail.com | Cont123* |

   @crearasignaturas
  Escenario: Crear una asignatura en el menu asignaturas
    Cuando crea una nueva asignatura llamada 'Asignatura Prueba'
    Entonces debería ver una notificación de éxito por la creación de la asignatura
