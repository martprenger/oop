package week1.crypto;

import java.util.Random;

public class Coin {

    private String code;
    private String name;
    private double price;
    private static Random random = new Random();

    public Coin(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public String getCode() { return code;}
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void fluctuate(double norm) {
        norm+=0.05-random.nextDouble()*0.10;
        price+=price*norm;
    }

}