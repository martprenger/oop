package week4.opgaveAdapter;

import java.util.function.Consumer;

public interface Mouse {

    public static final int BUTTON_NONE = 0;
    public static final int BUTTON_LEFT = 1;
    public static final int BUTTON_RIGHT = 2;

    int getX();
    int getY();
    int getButtonStatus();
    void setOnAction(Consumer<Mouse> action);

}