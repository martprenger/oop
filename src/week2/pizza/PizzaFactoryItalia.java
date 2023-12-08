package week2.pizza;

public class PizzaFactoryItalia implements PizzaFactory{

    private static PizzaFactoryItalia instance;

    private PizzaFactoryItalia() {}

    public static PizzaFactoryItalia getInstance() {
        if (instance==null) {
            instance = new PizzaFactoryItalia();
        }
        return instance;
    }
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
