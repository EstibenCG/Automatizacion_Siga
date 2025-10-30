#language: es
#author: Estiben

Característica: Crear asignatura en la página
  Como usuario autenticado
  Quiero crear una nueva asignatura
  para usarla más adelante

  @login @crearasignaturas
  Escenario: Crear una asignatura en el menú asignaturas
    Dado que el usuario ya inició sesión
    Cuando crea una nueva asignatura
      | nombre              |
      | Asignatura Prueba   |
    Entonces la asignatura deberia verse reflejada en el panel
