package week6.opgaveState1;

public class Order {

    private final State openOrder = new OpenOrder(this);
    private final State paidOrder = new PaidOrder(this);
    private final State sentOrder = new SentOrder(this);

    private State state = openOrder;

    public void payOrder() {
        state.payOrder();
    }

    public void sendOrder() {
        state.sendOrder();
    }

    public void returnOrder() {
        state.returnOrder();
    }

    public void refundOrder() {
        state.refundOrder();
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getOpenOrder() {
        return openOrder;
    }

    public State getPaidOrder() {
        return paidOrder;
    }

    public State getSentOrder() {
        return sentOrder;
    }

    public State getState() {
        return state;
    }
}
