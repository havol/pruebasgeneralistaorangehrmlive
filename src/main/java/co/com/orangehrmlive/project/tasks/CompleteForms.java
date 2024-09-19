package co.com.orangehrmlive.project.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static co.com.orangehrmlive.project.utils.Constants.HIRE_CANDIDATE;
import static co.com.orangehrmlive.project.utils.Constants.MARK_INTERVIEW_PASSED;
import static co.com.orangehrmlive.project.utils.Constants.OFFER_JOB;
import static co.com.orangehrmlive.project.utils.Constants.RECRUITMENT;
import static co.com.orangehrmlive.project.utils.Constants.SCHEDULE_INTERVIEW;
import static co.com.orangehrmlive.project.utils.Constants.SHORTLIST_CANDIDATE;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CompleteForms implements Task {
    private final String form;

    public CompleteForms(String form) {
        this.form = form;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        switch (form) {
            case RECRUITMENT:
                theActorInTheSpotlight().attemptsTo(
                        CompleteRecruitment.thisPage()
                );
                break;
            case SHORTLIST_CANDIDATE:
                theActorInTheSpotlight().attemptsTo(
                        CompleteShortListCandidate.thisPage()
                );
                break;
            case SCHEDULE_INTERVIEW:
                theActorInTheSpotlight().attemptsTo(
                        CompleteScheduleInterview.thisPage()
                );
                break;
            case MARK_INTERVIEW_PASSED:
                theActorInTheSpotlight().attemptsTo(
                        CompleteCandidate.thisPage()
                );
                break;
            case OFFER_JOB:
                theActorInTheSpotlight().attemptsTo(
                        CompleteOfferJob.thisPage()
                );
                break;
            case HIRE_CANDIDATE:
                theActorInTheSpotlight().attemptsTo(
                        CompleteHire.thisPage()
                );
                break;
            default:
                break;
        }
    }

    public static CompleteForms page(String form) {
        return instrumented(CompleteForms.class, form);
    }

}