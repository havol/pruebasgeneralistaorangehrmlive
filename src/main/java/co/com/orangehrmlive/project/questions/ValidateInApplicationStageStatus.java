package co.com.orangehrmlive.project.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.orangehrmlive.project.ui.RecruitmentUI.HIRED_STATUS_PARAGRAPH;

public class ValidateInApplicationStageStatus implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return HIRED_STATUS_PARAGRAPH.resolveFor(actor).getText();
    }

    public static ValidateInApplicationStageStatus paragraphStatus() {
        return new ValidateInApplicationStageStatus();
    }

}