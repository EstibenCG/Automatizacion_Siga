#language: es
#author: Edwin1538

Característica: Crear acudiente
  Como usuario autenticado
  Quiero registrar un acudiente
  Para que a este lleguen los reportes generados

  @login @crearAcudiente
  Escenario: Crear un acudiente
    Dado que el usuario ya inició sesión
    Cuando crea un acudiente
      | nombre | apellido | correo             |
      | Juanes | Pérezoso | juanperez@mail.com |
    Entonces el acudiente debe quedar registrado
