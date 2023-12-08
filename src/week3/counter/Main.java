package week3.counter;

public class Main {
    public static void main(String[] args) {
        CounterRunner cr1 = new CounterRunner();
        CounterRunner cr2 = new CounterRunner();
        CounterRunner cr3 = new CounterRunner();
        CounterRunner cr4 = new CounterRunner();
        Thread t1 = new Thread(cr1);
        Thread t2 = new Thread(cr2);
        Thread t3 = new Thread(cr3);
        Thread t4 = new Thread(cr4);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
