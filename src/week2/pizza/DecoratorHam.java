package week2.pizza;

public class DecoratorHam extends PizzaDecorator {

    public DecoratorHam(Pizza pizza) {
        super(pizza);
    }

    @Override
    public double getPrice() {
        return pizza.getPrice()+2.0;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription()+" Ham";
    }
}