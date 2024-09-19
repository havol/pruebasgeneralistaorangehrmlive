package co.com.orangehrmlive.project.tasks;

import co.com.orangehrmlive.project.interactions.excel.CaptureInformationUnfiltered;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class ReadExcel implements Task {

    public ReadExcel() {
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                CaptureInformationUnfiltered.inExcel()
        );
    }

    public static ReadExcel withoutFilters() {
        return Tasks.instrumented(ReadExcel.class);
    }

}