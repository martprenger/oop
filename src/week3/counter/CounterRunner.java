package week3.counter;

public class CounterRunner implements Runnable {
    @Override
    public void run() {
        SingletonCounter counter = SingletonCounter.getInstance();
        for (int i = 0; i < 3; i++) System.out.println(counter.count());
    }
}
