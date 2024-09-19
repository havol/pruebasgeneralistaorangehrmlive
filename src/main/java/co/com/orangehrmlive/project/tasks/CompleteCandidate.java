package co.com.orangehrmlive.project.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.orangehrmlive.project.ui.RecruitmentUI.APPLICATION_STAGE_HEADING;
import static co.com.orangehrmlive.project.ui.RecruitmentUI.CANDIDATE_LABEL;
import static co.com.orangehrmlive.project.ui.RecruitmentUI.MARK_INTERVIEW_PASSED_BUTTON;
import static co.com.orangehrmlive.project.ui.RecruitmentUI.SAVE_BUTTON;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CompleteCandidate implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(MARK_INTERVIEW_PASSED_BUTTON),
                WaitUntil.the(CANDIDATE_LABEL, isVisible())
                        .forNoMoreThan(10).seconds(),
                Click.on(SAVE_BUTTON),
                WaitUntil.the(APPLICATION_STAGE_HEADING, isVisible())
                        .forNoMoreThan(10).seconds()
        );
    }

    public static CompleteCandidate thisPage() {
        return Tasks.instrumented(CompleteCandidate.class);
    }

}