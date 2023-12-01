package week2.plaatjes.decorators;

import edu.princeton.cs.introcs.Picture;
import week2.plaatjes.ImageProcessor;
public class EffectBrighter extends ImageProcessorDecorator{

    public EffectBrighter(ImageProcessor imageProcessor) { super(imageProcessor); }

    @Override
    public Picture process() {
        Picture picture = super.process();
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
}
