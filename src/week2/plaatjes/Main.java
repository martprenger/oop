package week2.plaatjes;

import edu.princeton.cs.introcs.Picture;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        ImageEffects imageEffects = new ImageEffects("/home/pyro/repos/oop/src/week2/plaatjes/cats/kat.jpg");
        imageEffects.getOriginal().show();
        imageEffects.doBlur().show();
    }
}
