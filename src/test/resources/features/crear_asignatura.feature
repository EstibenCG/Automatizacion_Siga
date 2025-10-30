#language: es
#author: Estiben

Característica: Crear asignatura en la pagina
  Como usuario autenticado
  Quiero crear un nueva asignatura
  que usare mas adelante

  @login @crearasignaturas
  Escenario: Crear una asignatura en el menu asignaturas
    Dado que el usuario ya inició sesión
    Cuando crea una nueva asignatura llamada 'Asignatura Prueba'
    Entonces debería ver una notificación de éxito por la creación de la asignatura
