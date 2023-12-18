package week4.opgaveAdapter;

public interface UserInterface {

    void linkTouchScreenInputDevice(TouchScreenInputDevice touchScreenInputDevice);
    void onTouch(int x, int y);
    void onLongTouch(int x, int y);

}