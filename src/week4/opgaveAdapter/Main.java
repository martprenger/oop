package week4.opgaveAdapter;

import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        WeatherStationUserInterface weatherStationUserInterface = new WeatherStationUserInterface();

        // Touchscreen input device driver instantiëren en koppelen
        TouchScreenInputABCMega touchScreen = new TouchScreenInputABCMega();
        weatherStationUserInterface.linkTouchScreenInputDevice(touchScreen);

        // Touchscreen mouse driver instantiëren en koppelen
        XYZSuperMouse mouse = new XYZSuperMouse();

        // hier hoort een regel te staan die de muis koppelt aan de gebruikersinterface
        weatherStationUserInterface.linkTouchScreenInputDevice(new MouseAdapter(mouse));
        // Acties van een gebruiker met het touchscreen (gesimuleerd)
        touchScreen.simulateUserActionPress(100, 120);
        touchScreen.simulateUserActionLongPress(40, 178);
        // Acties van een gebruiker met de muis (gesimuleerd)
        mouse.simulateUserActionMove(300, 150);
        mouse.simulateUserActionClickLeft();
        mouse.simulateUserActionMove(300, 130);
        mouse.simulateUserActionMove(200, 130);
        mouse.simulateUserActionClickRight();
    }
}
