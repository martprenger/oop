package week2.plaatjes.decorators;

import edu.princeton.cs.introcs.Picture;
import week2.plaatjes.ImageProcessor;

abstract public class ImageProcessorDecorator implements ImageProcessor {
    private ImageProcessor imageProcessor;

    public ImageProcessorDecorator(ImageProcessor imageProcessor) {
        this.imageProcessor = imageProcessor;
    }

    @Override
    public Picture process() {
        return imageProcessor.process();
    }
}
