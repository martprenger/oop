package week4.opgaveAdapter;

public class WeatherStationUserInterface implements UserInterface {

    public WeatherStationUserInterface() {
        System.out.println("Weerstation UI versie 1.0");
    }

    @Override
    public void linkTouchScreenInputDevice(TouchScreenInputDevice touchScreenInputDevice) {
        touchScreenInputDevice.registerUserInterface(this);
    }

    @Override
    public void onTouch(int x, int y) {
        System.out.println("WEERSTATION UI scherm aangeraakt "+x+","+y);
    }

    @Override
    public void onLongTouch(int x, int y) {
        System.out.println("WEERSTATION UI scherm aangeraakt [lang] "+x+","+y);
    }

}