package week6.practicumState;

public class CardInsertedState implements State {

    private ATM atm;

    public CardInsertedState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard() {
        System.out.println("Card already inserted.");
    }

    @Override
    public void enterPincode(String pin) {
        if (pin.equals("1234")) {
            System.out.println("Pincode correct");
            atm.setState(atm.getPincodeEnteredState());
        } else {
            System.out.println("Incorrect pincode");
        }
    }

    @Override
    public void enterAmount(int amount) {
        System.out.println("Cannot enter amount.");
    }

    @Override
    public void takeMoney() {
        System.out.println("No money.");
    }

    @Override
    public void cancel() {
        System.out.println("canceld transaction");
        atm.setState(atm.getWaitingForCardState());
    }
}