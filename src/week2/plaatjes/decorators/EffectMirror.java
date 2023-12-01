package week2.plaatjes.decorators;

import edu.princeton.cs.introcs.Picture;
import week2.plaatjes.ImageProcessor;
public class EffectMirror extends ImageProcessorDecorator{
    public static final int MIRROR_HORIZONTAL = 1;
    public static final int MIRROR_VERTICAL = 2;

    int orientation;

    public EffectMirror(ImageProcessor imageProcessor, int orientation) {
        super(imageProcessor);
        this.orientation = orientation;
    }

    @Override
    public Picture process() {
        Picture picture = super.process();
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
}
