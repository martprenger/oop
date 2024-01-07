package week6.practicumState;

public class MoneyDeliveredState implements State{
    private ATM atm;

    public MoneyDeliveredState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard() {
        System.out.println("Card already inserted.");
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
        System.out.println("Money and card taken. Good bye!");
        atm.setState(atm.getWaitingForCardState());
    }

    @Override
    public void cancel() {
        System.out.println("canceld transaction");
        atm.setState(atm.getWaitingForCardState());
    }
}
