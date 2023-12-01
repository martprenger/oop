package week2.loggers;

public class GeneralLoggerFactory2 implements LoggerFactory2{
    @Override
    public Logger createLogger(int type) {
        if (type==CONSOLE_LOGGER) {
            return new ConsoleLogger();
        } else if (type==FILE_LOGGER) {
            return new FileLogger();
        }
        return null;
    }
}
