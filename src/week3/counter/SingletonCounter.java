package week3.counter;

public class SingletonCounter {

    private volatile int counter;

    private static SingletonCounter singletonCounter;

    private SingletonCounter() {
        System.out.println("Hello from constructor SingletonCounter");
        for(int i=0; i<30000; i++) {
            for(int j=0; j<i; j++) {
                counter++;
            }
        };
        counter=0;
    }

    public static synchronized SingletonCounter getInstance() {
        if (singletonCounter ==null) {
            singletonCounter = new SingletonCounter();
        }
        return singletonCounter;
    }

    /**
     * Increase counter and return new value of counter (thread safe)
     * @return new value of counter
     */
    synchronized public int count() {
        return ++counter;
    }

}