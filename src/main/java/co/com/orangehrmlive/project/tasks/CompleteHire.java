package co.com.orangehrmlive.project.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.orangehrmlive.project.ui.RecruitmentUI.APPLICATION_STAGE_HEADING;
import static co.com.orangehrmlive.project.ui.RecruitmentUI.HIRE_BUTTON;
import static co.com.orangehrmlive.project.ui.RecruitmentUI.HIRE_CANDIDATE_HEADING;
import static co.com.orangehrmlive.project.ui.RecruitmentUI.SAVE_BUTTON;
import static co.com.orangehrmlive.project.utils.Constants.TIME_SHORT;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CompleteHire implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HIRE_BUTTON),
                WaitUntil.the(HIRE_CANDIDATE_HEADING, isVisible())
                        .forNoMoreThan(TIME_SHORT).seconds(),
                Click.on(SAVE_BUTTON),
                WaitUntil.the(APPLICATION_STAGE_HEADING, isVisible())
                        .forNoMoreThan(TIME_SHORT).seconds()
        );
    }

    public static CompleteHire thisPage() {
        return Tasks.instrumented(CompleteHire.class);
    }

}