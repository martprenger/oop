package week2.pizza;

public class PizzaFactoryMilaan implements PizzaFactory{
    @Override
    public Pizza createPizza(String name) {
        switch (name) {
            case "Denna":
                return null;
            case "Samplice":
                return null;
            case "Sanremo":
                return null;
            case "Al Tonno":
                return null;
            default:
                throw new IllegalArgumentException("unknown pizza: " + name);
        }
    }
}
