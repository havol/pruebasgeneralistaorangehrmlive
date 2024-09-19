package co.com.orangehrmlive.project.stepdefinitions;

import co.com.orangehrmlive.project.questions.ValidateDashboard;
import co.com.orangehrmlive.project.tasks.Login;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static co.com.orangehrmlive.project.utils.Constants.ACTOR;
import static co.com.orangehrmlive.project.utils.Constants.PWD;
import static co.com.orangehrmlive.project.utils.Constants.USER_NAME;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import net.thucydides.core.util.EnvironmentVariables;
import org.hamcrest.Matchers;

public class InicioSeccionStep {

    private static EnvironmentVariables environmentVariables;
    private String user;
    private String pwd;

    @Before
    public void setTheStage() {
        //hector.can(BrowseTheWeb.with(hisBrowser));
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled(ACTOR);
    }

    @Cuando("ingresa las credenciales")
    public void ingresaLasCredenciales() {
        user = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(USER_NAME);
        pwd = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(PWD);
        theActorInTheSpotlight().attemptsTo(
                Login.authentication(user, pwd)
        );
    }

    @Entonces("se visualizara el {string} correctamente")
    public void seVisualizaraElDashboardCorrectamente(String txtDashboard) {
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(
                        ValidateDashboard.title(),
                        Matchers.containsString(txtDashboard)
                )
        );
    }

}