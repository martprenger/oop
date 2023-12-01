package week2.loggers;

public interface LoggerFactory2 {

    public static final int CONSOLE_LOGGER = 1;
    public static final int FILE_LOGGER = 2;

    Logger createLogger(int type);

}