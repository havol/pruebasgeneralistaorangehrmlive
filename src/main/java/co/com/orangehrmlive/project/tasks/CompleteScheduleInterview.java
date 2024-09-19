package co.com.orangehrmlive.project.tasks;

import co.com.orangehrmlive.project.enums.Constants;
import co.com.orangehrmlive.project.models.ParameterOrangeHRM;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

import static co.com.orangehrmlive.project.ui.RecruitmentUI.*;
import static co.com.orangehrmlive.project.utils.Constants.TIME_SHORT;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CompleteScheduleInterview implements Task {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompleteScheduleInterview.class);

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<ParameterOrangeHRM> listData = actor.recall(Constants.INFORMATION_EXCEL.getValue());

        String strInterviewTitle = listData.get(0).getStrInterViewTitle();
        LOGGER.info("Interview Title es => " + strInterviewTitle);
        String strInterviewer = listData.get(0).getStrInterviewer();
        LOGGER.info("Interviewer es => " + strInterviewer);
        String strDate = listData.get(0).getStrDateI();
        LOGGER.info("Date es => " + strDate);

        actor.attemptsTo(
                WaitUntil.the(SCHEDULE_INTERVIEW_BUTTON, isVisible())
                        .forNoMoreThan(10).seconds(),
                Click.on(SCHEDULE_INTERVIEW_BUTTON),
                WaitUntil.the(SCHEDULE_INTERVIEW_HEADING, isVisible())
                        .forNoMoreThan(10).seconds(),
                Click.on(INTERVIEW_TITLE_INPUT_FIELD),
                Enter.theValue(strInterviewTitle).into(INTERVIEW_TITLE_INPUT_FIELD),
                Click.on(INTERVIEWER_INPUT_FIELD),
                WaitUntil.the(INTERVIEWER_INPUT_FIELD, isVisible())
                        .forNoMoreThan(5).seconds()
        );

        Robot robot= null;
        try {
            robot = new Robot();
            robot.delay(5000);
            robot.keyPress(KeyEvent.VK_A);
            robot.keyRelease(KeyEvent.VK_A);
            robot.delay(5000);
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);
            robot.delay(2000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        actor.attemptsTo(
                Enter.theValue(strDate).into(DATE_INPUT_FIELD),
                Click.on(SAVE_BUTTON),
                WaitUntil.the(APPLICATION_STAGE_HEADING, isVisible())
                        .forNoMoreThan(TIME_SHORT).seconds()
        );

    }

    public static CompleteScheduleInterview thisPage() {
        return Tasks.instrumented(CompleteScheduleInterview.class);
    }

}