package co.com.orangehrmlive.project.utils;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class WriteWordWithRobot {


    public static void typeEmail(String email) throws Exception {
        Robot robot = new Robot();
        robot.delay(200);

        for (char c : email.toCharArray()) {
            int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);

            if (c == '@') {
                keyCode = KeyEvent.VK_AT;
            }

            if (c == '.') {
                keyCode = KeyEvent.VK_PERIOD;
            }

            robot.keyPress(keyCode);
            robot.keyRelease(keyCode);
            robot.delay(50);
        }
    }


    public static void copyAndPaste(String text) throws Exception {
        Robot robot = new Robot();
        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection,
        null);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

}