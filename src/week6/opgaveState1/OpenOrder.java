package week6.opgaveState1;

public class OpenOrder implements State{
    Order order;
    public OpenOrder(Order order) {
        this.order = order;
    }

    @Override
    public void payOrder() {
        System.out.println("Order is paid");
        order.setState(order.getPaidOrder());
    }

    @Override
    public void sendOrder() {
        System.out.println("Order is not paid yet");
    }

    @Override
    public void returnOrder() {
        System.out.println("Order is not paid yet");
    }

    @Override
    public void refundOrder() {
        System.out.println("Order is not paid yet");
    }
}
