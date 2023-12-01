package week2.plaatjes;

import edu.princeton.cs.introcs.Picture;

public class EffectRed extends ImageProcessorDecorator {

    public EffectRed(ImageProcessor imageProcessor) {
        super(imageProcessor);
    }

    @Override
    public Picture process() {
    }

}