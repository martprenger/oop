package week6.opgaveState1;

public interface State {
    void payOrder();
    void sendOrder();
    void returnOrder();
    void refundOrder();
}
