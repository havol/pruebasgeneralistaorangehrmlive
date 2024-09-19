package co.com.orangehrmlive.project.utils;

import java.awt.AWTException;
import java.awt.Robot;

public class ScrollHandler {

    private Robot robot;

    public ScrollHandler() {
        try {
            this.robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al inicializar Robot", e);
        }
    }

    public void scrollDown(int scrollAmount) {
        for (int i = 0; i < scrollAmount; i++) {
            robot.mouseWheel(1); // Desplazar hacia abajo
            robot.delay(100); // Retraso de 100 milisegundos entre cada desplazamiento
        }
    }

}