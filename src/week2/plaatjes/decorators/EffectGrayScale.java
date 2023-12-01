package week2.plaatjes.decorators;

import edu.princeton.cs.introcs.Picture;
import week2.plaatjes.ImageProcessor;
public class EffectGrayScale extends ImageProcessorDecorator{

    public EffectGrayScale(ImageProcessor imageProcessor) { super(imageProcessor); }

    @Override
    public Picture process() {
        Picture picture = super.process();
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
}
