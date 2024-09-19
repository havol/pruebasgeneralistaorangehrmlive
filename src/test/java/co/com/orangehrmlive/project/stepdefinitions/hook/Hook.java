package co.com.orangehrmlive.project.stepdefinitions.hook;

import co.com.orangehrmlive.project.tasks.OpenWeb;

import co.com.orangehrmlive.project.tasks.ReadExcel;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import org.hamcrest.Matchers;

import static co.com.orangehrmlive.project.utils.Constants.*;
import static co.com.orangehrmlive.project.utils.Time.waiting;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class Hook {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("{string} abre el sitio web de Orange HRM")
    public void abreElSitioWebDeOrangeHRM(String actor) {
        OnStage.theActorCalled(actor).attemptsTo(
                OpenWeb.browserURL(WEB_URL_MAP),
                ReadExcel.withoutFilters()
        );
        waiting(TIME_SHORT);
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(
                        TheWebPage.title(),
                        Matchers.containsString(TITLE_WEBSITE)
                )
        );
    }

    @Given("{string} abre el sitio web Floristeria en Medellin San Angel")
    public void abreElSitioWebFloristeriaMedellinSanAngel(String actor) {
        OnStage.theActorCalled(actor).attemptsTo(
                OpenWeb.browserURL(WEB_URL_FLOWER_SHOP)
        );
        waiting(TIME_SHORT);
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(
                        TheWebPage.title(),
                        Matchers.containsString(TITLE_WEBSITE_FLOWER)
                )
        );
    }


}