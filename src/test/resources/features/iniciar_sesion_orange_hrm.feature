# language: es
# author: Hector Alejandro Vargas Ochoa
# email: havargas8a@gmail.com
# se procede a crear la estructura, el escenario del gherkin en español.
# En este se hace solo el inicio de seccion Exitosa de Orange HRM

@authenticationLogin
Característica: Autenticación exitosa

  Yo como TAE(Test automation engineer)
  Quiero realizar una prueba de autenticación al sitio web
  Para comprobar la robustes y control de errores del aplicativo web, funcione correctamente


  Antecedentes:
    Dado "Hector" abre el sitio web de Orange HRM

  @authenticationSuccess
  Escenario: Autenticación de usuario exitosa.
    Cuando ingresa las credenciales
    Entonces se visualizara el "Dashboard" correctamente