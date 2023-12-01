package week2.loggers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class FileLogger implements Logger{

    private PrintWriter logfile;

    public FileLogger() {
        try {
            FileWriter fw = new FileWriter("src/week2/loggers/logfile.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            logfile = new PrintWriter(bw, true);
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
            e.printStackTrace();
            System.exit(1);
        }
    }
    @Override
    public void log(String message) {
        LocalDateTime currentTime = LocalDateTime.now();
        logfile.printf("%s %s\n", currentTime, message);
    }
}
