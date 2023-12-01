package week2.pizza;

public class DecoratorAnnanas extends PizzaDecorator {

    public DecoratorAnnanas(Pizza pizza) {
        super(pizza);
    }

    @Override
    public double getPrice() {
        return pizza.getPrice()+1.0;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription()+" Annanas";
    }
}