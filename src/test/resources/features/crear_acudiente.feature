#language: es
#author: Edwin1538

Característica: Crear acudiente
  Como usuario autenticado
  Quiero registrar un acudiente
  Para que a este lleguen los reportes generados

  Antecedentes:
    Dado que el usuario se encuentra en la página de inicio de sesión
    Cuando el usuario ingrese las credenciales válidas
      | Usuario          | Clave    |
      | andres@gmail.com | Contra1234+ |

  @crearAcudiente
  Escenario: Crear un acudiente
    Cuando crea un acudiente
      | nombre    | apellido | correo              |
      | Juanasasa | Pérezosi | juanpereza@mail.com |
    Entonces el acudiente debe quedar registrado
