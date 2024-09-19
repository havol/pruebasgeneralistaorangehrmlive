package co.com.orangehrmlive.project.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ScrollDownMultipleTimes implements Interaction {

    private final int numberOfScrolls;

    public ScrollDownMultipleTimes(int numberOfScrolls) {
        this.numberOfScrolls = numberOfScrolls;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        for (int i = 0; i < numberOfScrolls; i++) {
            actor.attemptsTo(
                    //Scroll.to(0, 1000) // Ajusta la distancia de desplazamiento según tus necesidades
            );
        }
    }

    public static Performable numberOfTimes(int numberOfScrolls) {
        return instrumented(ScrollDownMultipleTimes.class, numberOfScrolls);
    }
}
