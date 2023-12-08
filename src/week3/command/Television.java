package week3.command;

public class Television {

    int volume=5;
    boolean on = false;

    public static int MAX_VOLUME=20;

    public void turnOn() {
        if (!on) {
            on=true;
            System.out.println("Television on");
        }
    }

    public void turnOff() {
        if (on) {
            on=false;
            System.out.println("Television off");
        }
    }

    public void volumeUp() {
        if (on && volume<MAX_VOLUME) {
            volume++;
            System.out.println("Volume up ("+volume+")");
        }
    }

    public void volumeDown() {
        if (on && volume>0) {
            volume--;
            System.out.println("Volume down ("+volume+")");
        }
    }

}