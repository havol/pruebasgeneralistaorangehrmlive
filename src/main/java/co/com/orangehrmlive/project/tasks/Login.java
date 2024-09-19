package co.com.orangehrmlive.project.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static co.com.orangehrmlive.project.ui.DashboardUI.TXT_DASHBOARD;
import static co.com.orangehrmlive.project.ui.LoginUI.BTN_LOGIN;
import static co.com.orangehrmlive.project.ui.LoginUI.INPUT_PASSWORD;
import static co.com.orangehrmlive.project.ui.LoginUI.INPUT_USERNAME;
import static co.com.orangehrmlive.project.utils.Constants.TIME_SHORT;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Login implements Task {

    private final String user;
    private final String pwd;

    public Login(String user, String pwd) {
        this.user = user;
        this.pwd = pwd;
    }

    @Override
    @Step("{0} se autentica y acepta la alert del mensaje")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(user).into(INPUT_USERNAME),
                Enter.theValue(pwd).into(INPUT_PASSWORD),
                Click.on(BTN_LOGIN),
                WaitUntil.the(TXT_DASHBOARD, isVisible())
                      .forNoMoreThan(TIME_SHORT).seconds()
        );
    }

    public static Login authentication(String user, String pwd) {
        return Tasks.instrumented(Login.class, user, pwd);
    }
}