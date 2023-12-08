package week3.loggers;

import week2.pizza.PizzaFactoryItalia;

public class Logger {

    private static Logger instance;

    private int lineNr;

    private Logger() {
        log("Instance of Logger created.");
    }

    public static Logger getInstance() {
        if (instance==null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String text) {
        lineNr++;
        System.out.println("LOG "+lineNr+": "+text);
    }

}