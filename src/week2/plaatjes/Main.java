package week2.plaatjes;

import week2.plaatjes.decorators.*;

public class Main {
    public static void main(String[] args) {
        ImageProcessor imageProcessor = new EffectDarker(new ImageProcessorFile("/home/pyro/repos/oop/src/week2/plaatjes/cats/kat.jpg"));
        imageProcessor.process().show();
    }
}
