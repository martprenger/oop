package week6.practicumState;

public class ATM {

    private final State waitingForCardState = new WaitingForCardState(this);
    private final State CardInsertedState = new CardInsertedState(this);
    private final State PincodeEnteredState = new PincodeEnteredState(this);
    private final State MoneyDeliveredState = new MoneyDeliveredState(this);
    private State state = waitingForCardState;

    private int balance = 1000;

    // Publieke methodes

    public void insertCard() {
        state.insertCard();
    }

    public void enterPincode(String pin) {
        state.enterPincode(pin);
    }

    public void enterAmount(int amount) {
        state.enterAmount(amount);
    }

    public void takeMoney() {
        state.takeMoney();
    }

    public void cancel() {
        state.cancel();
    }

    // Setter voor de huidige toestand
    void setState(State state) {
        this.state = state;
    }

    // Methodes die aangeroepen worden vanuit de states

    // todo

    // Getters voor de states

    public State getWaitingForCardState() {
        return waitingForCardState;
    }

    public State getCardInsertedState() {
        return CardInsertedState;
    }

    public State getPincodeEnteredState() {
        return PincodeEnteredState;
    }

    public State getMoneyDeliveredState() {
        return MoneyDeliveredState;
    }

    int getBalance() {
        return balance;
    }

    void removeMoney(int amount) {
        balance-=amount;
    }
}