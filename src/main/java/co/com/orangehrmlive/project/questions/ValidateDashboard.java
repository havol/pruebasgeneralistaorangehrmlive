package co.com.orangehrmlive.project.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.orangehrmlive.project.ui.DashboardUI.TXT_DASHBOARD;

public class ValidateDashboard implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return TXT_DASHBOARD.resolveFor(actor).getText();
    }

    public static ValidateDashboard title() {
        return new ValidateDashboard();
    }

}