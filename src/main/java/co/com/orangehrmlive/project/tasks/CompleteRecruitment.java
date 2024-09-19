package co.com.orangehrmlive.project.tasks;

import co.com.orangehrmlive.project.utils.WriteWordWithRobot;
import net.serenitybdd.screenplay.actions.Enter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.orangehrmlive.project.models.ParameterOrangeHRM;
import co.com.orangehrmlive.project.enums.Constants;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.orangehrmlive.project.ui.MenuUI.LINK_RECRUITMENT;
import static co.com.orangehrmlive.project.ui.RecruitmentUI.ADD_BUTTON;
import static co.com.orangehrmlive.project.ui.RecruitmentUI.ADD_CANDIDATE_HEADING;
import static co.com.orangehrmlive.project.ui.RecruitmentUI.APPLICATION_STAGE_HEADING;
import static co.com.orangehrmlive.project.ui.RecruitmentUI.DROPDOWN_VACANCY;
import static co.com.orangehrmlive.project.ui.RecruitmentUI.FIRST_NAME_FIELD;
import static co.com.orangehrmlive.project.ui.RecruitmentUI.LAST_NAME_FIELD;
import static co.com.orangehrmlive.project.ui.RecruitmentUI.MIDDLE_NAME_FIELD;
import static co.com.orangehrmlive.project.ui.RecruitmentUI.RECRUITMENT_HEADING;
import static co.com.orangehrmlive.project.ui.RecruitmentUI.SAVE_BUTTON;
import static co.com.orangehrmlive.project.utils.Constants.TIME_SHORT;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class CompleteRecruitment implements Task {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompleteRecruitment.class);

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<ParameterOrangeHRM> listData = actor.recall(Constants.INFORMATION_EXCEL.getValue());

        String strFirtsname = listData.get(0).getStrFirstname();
        LOGGER.info("El primer Nombre es => " + strFirtsname);
        String strMiddlename = listData.get(0).getStrMiddleName();
        LOGGER.info("La segundo Nombre es => " + strMiddlename);
        String strLastname = listData.get(0).getStrLastname();
        String strVacancy = listData.get(0).getStrVacancy();
        LOGGER.info("Vacancy es => " + strVacancy);

        String[] words = new String[]{strVacancy};
        String firstCharacter = "";
        for (String word : words) {
            firstCharacter = String.valueOf(word.charAt(0));
        }
        LOGGER.info("La primera palabra de Vacancy es => " + firstCharacter);

        String strEmail = listData.get(0).getStrEmail();
        LOGGER.info("Email es => " + firstCharacter);

        actor.attemptsTo(
                Click.on(LINK_RECRUITMENT),
                WaitUntil.the(RECRUITMENT_HEADING, isVisible())
                        .forNoMoreThan(TIME_SHORT).seconds(),
                Click.on(ADD_BUTTON),
                WaitUntil.the(ADD_CANDIDATE_HEADING, isVisible())
                        .forNoMoreThan(TIME_SHORT).seconds(),
                Enter.theValue(strFirtsname).into(FIRST_NAME_FIELD),
                Enter.theValue(strMiddlename).into(MIDDLE_NAME_FIELD),
                Enter.theValue(strLastname).into(LAST_NAME_FIELD),
                Click.on(DROPDOWN_VACANCY)
                //Enter.theValue(firstCharacter).into(DROPDOWN_VACANCY)
                //Click.on(DROPDOWN_VACANCY),
                //Click.on(DYNAMIC_TEXT_DROPDOWN_VACANCY.of(strVacancy))
        );
        Robot robot= null;
        try {
            robot = new Robot();
            robot.delay(2000);
            robot.keyPress(KeyEvent.VK_Q);
            robot.keyRelease(KeyEvent.VK_Q);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            WriteWordWithRobot.copyAndPaste(strEmail);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        actor.attemptsTo(
                Click.on(SAVE_BUTTON),
                WaitUntil.the(APPLICATION_STAGE_HEADING, isVisible())
                        .forNoMoreThan(TIME_SHORT).seconds()
        );
    }

    public static CompleteRecruitment thisPage() {
        return Tasks.instrumented(CompleteRecruitment.class);
    }

}