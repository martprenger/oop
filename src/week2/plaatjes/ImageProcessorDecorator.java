package week2.plaatjes;

abstract public class ImageProcessorDecorator implements ImageProcessor{
    private ImageProcessor imageProcessor;

    public ImageProcessorDecorator(ImageProcessor imageProcessor) {
        this.imageProcessor = imageProcessor;
    }
}
