package week4.opgaveAdapter;

import java.util.function.Consumer;

public class MouseAdapterClick implements Consumer<Mouse> {
    private MouseAdapter mouseAdapter;

    public MouseAdapterClick(MouseAdapter mouseAdapter) {
        this.mouseAdapter = mouseAdapter;
    }

    @Override
    public void accept(Mouse mouse) {
        switch (mouse.getButtonStatus()) {
            case Mouse.BUTTON_LEFT:
                mouseAdapter.simulateUserActionPress(mouse.getX(),mouse.getY());
                break;
            case Mouse.BUTTON_RIGHT:
                mouseAdapter.simulateUserActionLongPress(mouse.getX(),mouse.getY());
                break;
            default:
                break;
        }
    }
}
