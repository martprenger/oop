package week2.loggers;

import java.time.LocalDateTime;

public class ConsoleLogger implements Logger{

    @Override
    public void log(String message) {
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.printf("%s %s\n", currentTime, message);
    }
}
