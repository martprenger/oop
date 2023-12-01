package week2.loggers;

public class FileLoggerFactory1 implements LoggerFactory1{
    @Override
    public Logger createLogger() {
        return new FileLogger();
    }
}
