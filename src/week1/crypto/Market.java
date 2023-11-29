package week1.crypto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Market implements Runnable,Subject{

    private boolean stop;
    private List<Coin> coins;
    private List<Observer> observers = new ArrayList<>();
    private Random random = new Random();

    public Market() {
        stop=false;
        coins=Collections.synchronizedList(new ArrayList<>());
        new Thread(this).start();
    }

    /*
    Coins toevoegen en verwijderen
     */

    public void addCoin(Coin coin) {
        coins.add(coin);
    }

    public void removeCoin(Coin coin) {
        coins.remove(coin);
    }

    /*
     Gegevens van aanwezige coins opvragen
     */
    public int getNumberOfCoins() {
        return coins.size();
    }

    public String getCoinName(int i) {
        return coins.get(i).getName();
    }

    public double getCoinPrice(int i) {
        return coins.get(i).getPrice();
    }
    public String getCoinName(String code) {
        return findCoinByCode(code).getName();
    }
    public double getCoinPrice(String code) {
        return findCoinByCode(code).getPrice();
    }
    private Coin findCoinByCode(String code) {
        for (Coin coin : coins) {
            if (coin.getCode().equals(code)){
                return coin;
            }
        }
        return new Coin("","",0);
    }

    /*
    Methodes om de prijs van de coins te laten fluctueren
     */

    private void fluctuate() {
        double norm=0.05-random.nextDouble()*0.10;
        for(Coin coin : coins) {
            coin.fluctuate(norm);
        }
    }

    public void stop() {
        stop=true;
    }

    @Override
    public void run() {
        while(!stop) {
            fluctuate();
            notifyObservers();
            try {
                Thread.sleep(300+random.nextInt(1700));
            } catch (InterruptedException e) {
                e.printStackTrace();
                stop();
            }
        }
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(this);
        }
    }
}