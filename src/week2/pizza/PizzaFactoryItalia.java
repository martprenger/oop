package week2.pizza;

public class PizzaFactoryItalia implements PizzaFactory{
    @Override
    public Pizza createPizza(String name) {
        switch (name) {
            case "Funghi":
                return new DecoratorMushrooms(new BasicPizza());
            case "Hawaii":
                return new DecoratorHam(new DecoratorAnnanas(new BasicPizza()));
            case "Samplice":
                return new DecoratorMushrooms(new DecoratorHam(new BasicPizza()));
            default:
                throw new IllegalArgumentException("unknown pizza: " + name);
        }
    }
}
