package co.com.orangehrmlive.project.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/iniciar_sesion_orange_hrm.feature",
        glue = "co.com.orangehrmlive.project.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = "pretty",
        tags = "@authenticationLogin"
)

public class InicioSeccionRunner {
}
