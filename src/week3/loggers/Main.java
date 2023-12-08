package week3.loggers;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getInstance();
        logger.log("Start program");
        ReadFile readFile = new ReadFile("/home/pyro/repos/oop/src/week3/loggers/test.txt");
        String[] lines= new String[0];
        try {
            lines = readFile.readLines();
            if (lines!=null) {
                for(String line : lines) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.log("Eind of program");
    }
}
