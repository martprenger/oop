package week4.opgaveAdapter;

public class TouchScreenInputABCMega implements TouchScreenInputDevice {

    private UserInterface userInterface;

    @Override
    public void registerUserInterface(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    // Hardware specifieke functies (afhankelijk van merk en type)

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