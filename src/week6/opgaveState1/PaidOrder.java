package week6.opgaveState1;

public class PaidOrder implements State{
    Order order;
    public PaidOrder(Order order) {
        this.order = order;
    }

    @Override
    public void payOrder() {
        System.out.println("Order is already paid");
    }

    @Override
    public void sendOrder() {
        System.out.println("Order is sent");
        order.setState(order.getSentOrder());
    }

    @Override
    public void returnOrder() {
        System.out.println("Order is not yet sent");
    }

    @Override
    public void refundOrder() {
        System.out.println("Order is refunded");
        order.setState(order.getOpenOrder());
    }
}
