package week2.plaatjes.decorators;

import edu.princeton.cs.introcs.Picture;
import week2.plaatjes.ImageProcessor;
public class EffectBlur extends ImageProcessorDecorator{

    public EffectBlur(ImageProcessor imageProcessor) { super(imageProcessor); }

    @Override
    public Picture process() {
        Picture oldPicture = super.process();
        Picture picture = super.process();
        for (int x = 1; x < picture.width() - 1; x++) {
            for (int y = 1; y < picture.height() - 1; y++) {
                int sumRed = (
                        ((oldPicture.getRGB(x - 1, y + 1) >> 16) & 0xFF) +
                                ((oldPicture.getRGB(x - 0, y + 1) >> 16) & 0xFF) +
                                ((oldPicture.getRGB(x + 1, y + 1) >> 16) & 0xFF) +
                                ((oldPicture.getRGB(x - 1, y + 0) >> 16) & 0xFF) +
                                ((oldPicture.getRGB(x - 0, y + 0) >> 16) & 0xFF) +
                                ((oldPicture.getRGB(x + 1, y + 0) >> 16) & 0xFF) +
                                ((oldPicture.getRGB(x - 1, y - 1) >> 16) & 0xFF) +
                                ((oldPicture.getRGB(x - 0, y - 1) >> 16) & 0xFF) +
                                ((oldPicture.getRGB(x + 1, y - 1) >> 16) & 0xFF)
                ) / 9;

                int sumGreen = (
                        ((oldPicture.getRGB(x - 1, y + 1) >> 8) & 0xFF) +
                                ((oldPicture.getRGB(x - 0, y + 1) >> 8) & 0xFF) +
                                ((oldPicture.getRGB(x + 1, y + 1) >> 8) & 0xFF) +
                                ((oldPicture.getRGB(x - 1, y + 0) >> 8) & 0xFF) +
                                ((oldPicture.getRGB(x - 0, y + 0) >> 8) & 0xFF) +
                                ((oldPicture.getRGB(x + 1, y + 0) >> 8) & 0xFF) +
                                ((oldPicture.getRGB(x - 1, y - 1) >> 8) & 0xFF) +
                                ((oldPicture.getRGB(x - 0, y - 1) >> 8) & 0xFF) +
                                ((oldPicture.getRGB(x + 1, y - 1) >> 8) & 0xFF)) / 9;

                int sumBlue = (
                        (oldPicture.getRGB(x - 1, y + 1) & 0xFF) +
                                (oldPicture.getRGB(x - 0, y + 1) & 0xFF) +
                                (oldPicture.getRGB(x + 1, y + 1) & 0xFF) +
                                (oldPicture.getRGB(x - 1, y + 0) & 0xFF) +
                                (oldPicture.getRGB(x - 0, y + 0) & 0xFF) +
                                (oldPicture.getRGB(x + 1, y + 0) & 0xFF) +
                                (oldPicture.getRGB(x - 1, y - 1) & 0xFF) +
                                (oldPicture.getRGB(x - 0, y - 1) & 0xFF) +
                                (oldPicture.getRGB(x + 1, y - 1) & 0xFF)
                ) / 9;

                int finalRGB = (0xFF << 24) | (sumRed << 16) | (sumGreen << 8) | sumBlue;

                picture.setRGB(x, y, finalRGB);
            }
        }

        return picture;
    }
}
