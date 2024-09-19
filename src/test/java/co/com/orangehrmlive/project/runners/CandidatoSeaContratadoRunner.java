package co.com.orangehrmlive.project.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/validar_que_el_candidato_sea_contratado.feature",
        glue = "co.com.orangehrmlive.project.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = "pretty",
        tags = "@candidateHiren"
)

public class CandidatoSeaContratadoRunner {
}
