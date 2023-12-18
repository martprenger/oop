package week4.opgaveAdapter;

public class MouseAdapter implements TouchScreenInputDevice{
    private UserInterface userInterface;

    public MouseAdapter(Mouse mouse) {
        mouse.setOnAction(new MouseAdapterClick(this));
    }

    @Override
    public void registerUserInterface(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    public void simulateUserActionPress(int x, int y) {
        if (userInterface!=null) {
            userInterface.onTouch(x,y);
        }
    }

    public void simulateUserActionLongPress(int x, int y) {
        if (userInterface!=null) {
            userInterface.onLongTouch(x,y);
        }
    }
}
