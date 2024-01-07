package week6.practicumState;

public class WaitingForCardState implements State {

    private ATM atm;

    public WaitingForCardState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard() {
        System.out.println("Card inserted.");
        atm.setState(atm.getCardInsertedState());
    }

    @Override
    public void enterPincode(String pin) {
        System.out.println("Cannot enter pincode.");
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