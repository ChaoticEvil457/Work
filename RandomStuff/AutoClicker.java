package RandomStuff;

import java.awt.*;

public class AutoClicker {
    private Robot robot;

    public AutoClicker() {
        try {
            robot = new Robot();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickMouse(int button) {
        try {
            robot.mousePress(button);
            robot.delay(5);
            robot.mouseRelease(button);
            robot.delay(5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
