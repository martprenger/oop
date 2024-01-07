package week6.practicumState;

public class PincodeEnteredState implements State{

    private ATM atm;

    public PincodeEnteredState(ATM atm) {
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
        if (amount>0 && amount <= atm.getBalance()) {
            System.out.println("EUR "+amount+" is delivered. Please take your money and card.");
            atm.removeMoney(amount);
            atm.setState(atm.getMoneyDeliveredState());
        } else {
            System.out.println("Cannot deliver money.");
        }
    }

    @Override
    public void cancel() {
        System.out.println("canceld transaction");
        atm.setState(atm.getWaitingForCardState());
    }

    @Override
    public void takeMoney() {
        System.out.println("No money.");
    }
}
