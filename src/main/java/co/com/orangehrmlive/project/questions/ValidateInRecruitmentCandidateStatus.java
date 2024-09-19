package co.com.orangehrmlive.project.questions;

import co.com.orangehrmlive.project.enums.Constants;
import co.com.orangehrmlive.project.models.ParameterOrangeHRM;
import co.com.orangehrmlive.project.ui.RecruitmentUI;
import co.com.orangehrmlive.project.utils.ScrollHandler;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static co.com.orangehrmlive.project.ui.MenuUI.LINK_RECRUITMENT;
import static co.com.orangehrmlive.project.ui.RecruitmentUI.RECRUITMENT_HEADING;
import static co.com.orangehrmlive.project.utils.Constants.MENU_RECRUITMENT;
import static co.com.orangehrmlive.project.utils.Constants.TIME_SHORT;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class ValidateInRecruitmentCandidateStatus implements Question<Boolean> {

    private final String option;
    private final String status;

    public ValidateInRecruitmentCandidateStatus(String option, String status) {
        this.option = option;
        this.status = status;
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        if (option.equals(MENU_RECRUITMENT)) {
            actor.attemptsTo(
                    Click.on(LINK_RECRUITMENT),
                    WaitUntil.the(RECRUITMENT_HEADING, isVisible())
                            .forNoMoreThan(TIME_SHORT).seconds()
            );
        }
        List<ParameterOrangeHRM> listData = actor.recall(Constants.INFORMATION_EXCEL.getValue());

        String strFirtsname = listData.get(0).getStrFirstname();

        try {
            ScrollHandler scrollHandler = new ScrollHandler();
            scrollHandler.scrollDown(5);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        actor.attemptsTo(
                Click.on(LINK_RECRUITMENT),
                WaitUntil.the(RECRUITMENT_HEADING, isVisible())
                        .forNoMoreThan(TIME_SHORT).seconds()
        );

        return RecruitmentUI.isCandidateWithStatusPresent(strFirtsname,status);
    }

    public static ValidateInRecruitmentCandidateStatus isHired(String option, String status) {
        return new ValidateInRecruitmentCandidateStatus(option,status);
    }

}