package co.com.orangehrmlive.project.stepdefinitions;

import co.com.orangehrmlive.project.questions.ValidateInApplicationStageStatus;
import co.com.orangehrmlive.project.questions.ValidateInRecruitmentCandidateStatus;
import co.com.orangehrmlive.project.tasks.CompleteForms;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.GivenWhenThen;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CandidatoSeaContratadoStep {

    @Cuando("completa el formulario {string}")
    public void completaElFormulario(String form) {
        theActorInTheSpotlight().attemptsTo(
                CompleteForms.page(form)
        );
    }

    @Entonces("Se compprueba que en la descripción se muestra el {string}")
    public void seCompruebaEnDescripcionQueSeMuestraStatusHiren(String status) {
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(
                        ValidateInApplicationStageStatus.paragraphStatus(),
                        Matchers.containsString(status)
                )
        );
    }

    @Entonces("también desde la opción {string} en la lista de Candidato se muestra el Status: {string}")
    public void enRecruitmentDeLaListaDeCandidatosSeMuestraStatusHiren(String option, String status) {
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(
                        ValidateInRecruitmentCandidateStatus.isHired(option, status),
                        Matchers.equalTo(true)
                )
        );
    }

}