package week2.pizza;

public class DecoratorOnions extends PizzaDecorator {
    public DecoratorOnions(Pizza pizza) {
        super(pizza);
    }

    @Override
    public double getPrice() {
        return pizza.getPrice()+1;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription()+" Onions";
    }
}
