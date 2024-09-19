package co.com.orangehrmlive.project.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectFromOption implements Interaction {

    private String strVisibleText;
    private Target idField;

    public SelectFromOption(String strVisibleText, Target idField) {
        this.strVisibleText = strVisibleText;
        this.idField = idField;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(SelectFromOptions.byVisibleText(strVisibleText).from(idField));
    }

    public static SelectFromOption dropDown(String strVisibleText, Target idField) {
        return instrumented(SelectFromOption.class,strVisibleText, idField);
    }

}