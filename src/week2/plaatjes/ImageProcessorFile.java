package week2.plaatjes;

import edu.princeton.cs.introcs.Picture;

public class ImageProcessorFile implements ImageProcessor {

    private Picture picture;

    ImageProcessorFile(String filename) {
        picture=new Picture(filename);
    }

    @Override
    public Picture process() {
        return picture;
    }
}