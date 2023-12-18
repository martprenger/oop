package week4.opgaveAdapter;

import java.util.function.Consumer;

public class XYZSuperMouse implements Mouse {

    private int x,y, buttonStatus;
    private Consumer<Mouse> action;

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getButtonStatus() {
        return buttonStatus;
    }

    @Override
    public void setOnAction(Consumer<Mouse> action) {
        this.action = action;
    }

    // Hardware specifieke functies (afhankelijk van merk en type)

    private void checkForAction() {
        if (action==null) {
            throw new IllegalStateException("No action set");
        }
    }

    public void simulateUserActionMove(int x, int y) {
        checkForAction();
        this.x=x;
        this.y=y;
        action.accept(this);
    }

    public void simulateUserActionClickLeft() {
        checkForAction();
        this.buttonStatus = BUTTON_LEFT;
        action.accept(this);
        this.buttonStatus = BUTTON_NONE;
    }

    public void simulateUserActionClickRight() {
        checkForAction();
        this.buttonStatus = BUTTON_RIGHT;
        action.accept(this);
        this.buttonStatus = BUTTON_NONE;
    }

}