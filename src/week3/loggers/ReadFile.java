package week3.loggers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

    private String filename;

    public ReadFile(String filename) {
        this.filename = filename;
    }

    public String[] readLines() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String[] lines = br.lines().toArray(String[]::new);
            Logger logger = Logger.getInstance();
            logger.log(lines.length+" lines read succesfully from file "+filename);
            return lines;
        } catch(FileNotFoundException e) {
            Logger logger = Logger.getInstance();
            logger.log("File "+filename+" not found");
        }
        return null;
    }
}