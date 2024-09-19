# language: es
# author: Hector Alejandro Vargas Ochoa
# email: havargas8a@gmail.com
# Escenario de prueba "validar que el estado sea Contratado, de un candidato en Reclutamiento".
# Resultado esperado: Status en Hired en la página Orange HRM
# Prerrequisito: Se debe crear manaul una vacancy con el nombre "QA sample" y asignar el evaluador,
#  de esta manera funciona el proceso de validación. No funciona si se escoge un existente.

@candidateHiren
Característica: Contratar un Candidato exitosa

  Yo como TAE(Test automation engineer)
  Quiero realizar una prueba de Contratar un candidato en Reclutamiento desde sitio web Orange HRM.
  Para comprobar la robustes y control de errores del aplicativo web, funcione correctamente


  Antecedentes:
    Dado "Hector" abre el sitio web de Orange HRM

  @candidateHirenSuccess
  Escenario: Validar que el estado sea Contratado, de un candidato en Reclutamiento sea exitosa.
    Cuando ingresa las credenciales
    Y completa el formulario "Recruitment"
    Y completa el formulario "Shortlist Candidate"
    Y completa el formulario "Schedule Interview"
    Y completa el formulario "Mark Interview Passed"
    Y completa el formulario "Offer Job"
    Y completa el formulario "Hire Candidate"
    Entonces Se compprueba que en la descripción se muestra el "Status: Hired"
    Y también desde la opción "Recruitment" en la lista de Candidato se muestra el Status: "Hired"