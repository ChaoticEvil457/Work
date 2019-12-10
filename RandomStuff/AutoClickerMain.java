package RandomStuff;

import java.awt.event.InputEvent;

public class AutoClickerMain {
    public static void main(String[] args) {
        AutoClicker auto = new AutoClicker();
        System.out.println("Start");
        try {
            Thread.sleep(5000);
        }
        catch(Exception e){

        }
        for(int i=0;i<5000;i++){
            auto.clickMouse(InputEvent.BUTTON1_MASK);
        }
    }
}