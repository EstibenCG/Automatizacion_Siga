#language: es
#author: Maria

Característica: Autenticación en la página de SIGA
  Como usuario administrador de SIGA
  Quiero iniciar sesión en la página
  Para poder acceder al contenido y funciones de administrador

  @login
  Escenario: Verificar la autenticación exitosa en la página de SIGA
    Dado que el usuario se encuentra en la página de inicio de sesión
    Cuando el usuario ingrese las credenciales válidas
      | Usuario         | Clave    |
      | maria@gmail.com | Cont123* |
    Entonces el sistema debe permitir el acceso y mostrar el panel de administrador
