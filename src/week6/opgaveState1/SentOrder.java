package week6.opgaveState1;

public class SentOrder implements State{
    Order order;
    public SentOrder(Order order) {
        this.order = order;
    }

    @Override
    public void payOrder() {
        System.out.println("Order is already paid");
    }

    @Override
    public void sendOrder() {
        System.out.println("Order is already sent");
    }

    @Override
    public void returnOrder() {
        System.out.println("Order is returned");
        order.setState(order.getPaidOrder());
    }

    @Override
    public void refundOrder() {
        System.out.println("Order is already sent");
    }
}
