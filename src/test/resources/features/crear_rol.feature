#language: es
#author: OctavioGallo

Característica: Crear rol

  Como usuario administrador
  Quiero registrar un nuevo rol en el sistema
  Para gestionar los permisos y accesos

  Antecedentes:
    Dado que el usuario se encuentra en la página de inicio de sesión
    Cuando el usuario ingrese las credenciales válidas
      | Usuario          | Clave    |
      | andres@gmail.com | 12345678 |

  @crearRol
  Escenario: Crear un rol básico
    Cuando crea un rol
      | nombre del rol |
      | Estudiante     |
    Entonces el rol debe quedar registrado