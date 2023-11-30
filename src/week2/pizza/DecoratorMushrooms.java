package week2.pizza;

public class DecoratorMushrooms extends PizzaDecorator {

    public DecoratorMushrooms(Pizza pizza) {
        super(pizza);
    }

    @Override
    public double getPrice() {
        return pizza.getPrice()+1.5;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription()+" Mushrooms";
    }
}