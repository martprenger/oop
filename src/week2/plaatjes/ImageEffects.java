package week2.plaatjes;

import com.sun.source.tree.NewArrayTree;
import edu.princeton.cs.introcs.Picture;

import java.awt.*;

public class ImageEffects {
    public static final int MIRROR_HORIZONTAL = 1;
    public static final int MIRROR_VERTICAL = 2;

    private Picture picture;

    ImageEffects(String filename) {
        picture = new Picture(filename);
    }

    public Picture getOriginal() {
        return new Picture(picture);
    }

    public Picture doRed() {
        Picture picture = new Picture(this.picture);
        for (int x = 0; x < picture.width(); x++) {
            for (int y = 0; y < picture.height(); y++) {
                int rgb = picture.getRGB(x, y);
                int red = (rgb >> 16) & 0xFF;
                int green = (rgb >> 8) & 0xFF;
                int blue = rgb & 0xFF;
                int avg = (red + green + blue) / 3; // gemiddelde berekenen
                red = avg; // gemiddelde intensiteit toekennen aan rood
                green = 0; // geen groen
                blue = 0; // geen blauw
                rgb = 0xFF000000 + (red << 16) + (green << 8) + blue; // 0xFF000000 -> transparantie
                picture.setRGB(x, y, rgb);
            }
        }
        return picture;
    }

    public Picture doGrayScale() {
        Picture picture = new Picture(this.picture);
        for (int x = 0; x < picture.width(); x++) {
            for (int y = 0; y < picture.height(); y++) {
                int rgb = picture.getRGB(x, y);
                int red = (rgb >> 16) & 0xFF;
                int green = (rgb >> 8) & 0xFF;
                int blue = rgb & 0xFF;
                int avg = (red + green + blue) / 3; // gemiddelde berekenen
                red = avg; // gemiddelde intensiteit toekennen aan rood
                green = avg; // geen groen
                blue = avg; // geen blauw
                rgb = 0xFF000000 + (red << 16) + (green << 8) + blue; // 0xFF000000 -> transparantie
                picture.setRGB(x, y, rgb);
            }
        }
        return picture;
    }

    public Picture doBrighter() {
        Picture picture = new Picture(this.picture);
        for (int x = 0; x < picture.width(); x++) {
            for (int y = 0; y < picture.height(); y++) {
                int rgb = picture.getRGB(x, y);
                int red = (rgb >> 16) & 0xFF;
                int green = (rgb >> 8) & 0xFF;
                int blue = rgb & 0xFF;

                // Increase brightness by adding a value to each color channel
                int brightnessIncrease = 30; // You can adjust this value to control brightness
                red = Math.min(255, red + brightnessIncrease); // Increase red channel
                green = Math.min(255, green + brightnessIncrease); // Increase green channel
                blue = Math.min(255, blue + brightnessIncrease); // Increase blue channel

                rgb = 0xFF000000 + (red << 16) + (green << 8) + blue; // Set new RGB value
                picture.setRGB(x, y, rgb);
            }
        }
        return picture;
    }

    public Picture doDarker() {
        Picture picture = new Picture(this.picture);
        for (int x = 0; x < picture.width(); x++) {
            for (int y = 0; y < picture.height(); y++) {
                int rgb = picture.getRGB(x, y);
                int red = (rgb >> 16) & 0xFF;
                int green = (rgb >> 8) & 0xFF;
                int blue = rgb & 0xFF;

                // Increase brightness by adding a value to each color channel
                int brightnessDecrease = 30; // You can adjust this value to control brightness
                red = Math.max(0, red - brightnessDecrease); // Increase red channel
                green = Math.max(0, green - brightnessDecrease); // Increase green channel
                blue = Math.max(0, blue - brightnessDecrease); // Increase blue channel

                rgb = 0xFF000000 + (red << 16) + (green << 8) + blue; // Set new RGB value
                picture.setRGB(x, y, rgb);
            }
        }
        return picture;
    }

    public Picture doMirror(int orientation) {
        Picture picture = new Picture(this.picture);
        int width = picture.width();
        int height = picture.height();

        if (orientation == MIRROR_VERTICAL) {
            for (int y = 0; y < height / 2; y++) {
                for (int x = 0; x < width; x++) {
                    int temp = picture.getRGB(x, y);
                    picture.setRGB(x, y, picture.getRGB(x, height - 1 - y));
                    picture.setRGB(x, height - 1 - y, temp);
                }
            }
        } else if (orientation == MIRROR_HORIZONTAL) {
            for (int x = 0; x < width / 2; x++) {
                for (int y = 0; y < height; y++) {
                    int temp = picture.getRGB(x, y);
                    picture.setRGB(x, y, picture.getRGB(width - 1 - x, y));
                    picture.setRGB(width - 1 - x, y, temp);
                }
            }
        }
        return picture;
    }

    public Picture doBlur() {
        Picture picture = new Picture(this.picture);

        for (int x = 1; x < picture.width() - 1; x++) {
            for (int y = 1; y < picture.height() - 1; y++) {
                int sumRed = (
                        ((this.picture.getRGB(x - 1, y + 1) >> 16) & 0xFF) +
                                ((this.picture.getRGB(x - 0, y + 1) >> 16) & 0xFF) +
                                ((this.picture.getRGB(x + 1, y + 1) >> 16) & 0xFF) +
                                ((this.picture.getRGB(x - 1, y + 0) >> 16) & 0xFF) +
                                ((this.picture.getRGB(x - 0, y + 0) >> 16) & 0xFF) +
                                ((this.picture.getRGB(x + 1, y + 0) >> 16) & 0xFF) +
                                ((this.picture.getRGB(x - 1, y - 1) >> 16) & 0xFF) +
                                ((this.picture.getRGB(x - 0, y - 1) >> 16) & 0xFF) +
                                ((this.picture.getRGB(x + 1, y - 1) >> 16) & 0xFF)
                ) / 9;

                int sumGreen = (
                        ((this.picture.getRGB(x - 1, y + 1) >> 8) & 0xFF) +
                                ((this.picture.getRGB(x - 0, y + 1) >> 8) & 0xFF) +
                                ((this.picture.getRGB(x + 1, y + 1) >> 8) & 0xFF) +
                                ((this.picture.getRGB(x - 1, y + 0) >> 8) & 0xFF) +
                                ((this.picture.getRGB(x - 0, y + 0) >> 8) & 0xFF) +
                                ((this.picture.getRGB(x + 1, y + 0) >> 8) & 0xFF) +
                                ((this.picture.getRGB(x - 1, y - 1) >> 8) & 0xFF) +
                                ((this.picture.getRGB(x - 0, y - 1) >> 8) & 0xFF) +
                                ((this.picture.getRGB(x + 1, y - 1) >> 8) & 0xFF)) / 9;

                int sumBlue = (
                        (this.picture.getRGB(x - 1, y + 1) & 0xFF) +
                                (this.picture.getRGB(x - 0, y + 1) & 0xFF) +
                                (this.picture.getRGB(x + 1, y + 1) & 0xFF) +
                                (this.picture.getRGB(x - 1, y + 0) & 0xFF) +
                                (this.picture.getRGB(x - 0, y + 0) & 0xFF) +
                                (this.picture.getRGB(x + 1, y + 0) & 0xFF) +
                                (this.picture.getRGB(x - 1, y - 1) & 0xFF) +
                                (this.picture.getRGB(x - 0, y - 1) & 0xFF) +
                                (this.picture.getRGB(x + 1, y - 1) & 0xFF)
                ) / 9;

                int finalRGB = (0xFF << 24) | (sumRed << 16) | (sumGreen << 8) | sumBlue;

                picture.setRGB(x, y, finalRGB);
            }
        }

        return picture;
    }

}