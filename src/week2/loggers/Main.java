package week2.loggers;

public class Main {
    public static void main(String[] args) {
        // Create factories
        LoggerFactory1 consoleLoggerFactory1 = new ConsoleLoggerFactory1();
        LoggerFactory1 fileLoggerFactory1= new FileLoggerFactory1();
        // Use factories to create loggers
        Logger consoleLogger1=consoleLoggerFactory1.createLogger();
        Logger fileLogger1=fileLoggerFactory1.createLogger();
        // Test loggers
        consoleLogger1.log("Message to logger made by factory 1");
        fileLogger1.log("Message to logger made by factory 1");

        // Create factory
        LoggerFactory2 generalLoggerFactory2 = new GeneralLoggerFactory2();
        // Use factory to create loggers
        Logger consoleLogger2=generalLoggerFactory2.createLogger(LoggerFactory2.CONSOLE_LOGGER);
        Logger fileLogger2=generalLoggerFactory2.createLogger(LoggerFactory2.FILE_LOGGER);
        // Test loggers
        consoleLogger2.log("Message to logger made by factory 2");
        fileLogger2.log("Message to logger made by factory 2");

        // Create factory
        LoggerFactory3 generalLoggerFactory3 = new GeneralLoggerFactory3();
        // Use factory to create loggers
        Logger consoleLogger3=generalLoggerFactory3.createConsoleLogger();
        Logger fileLogger3=generalLoggerFactory3.createFileLogger();
        // Test loggers
        consoleLogger3.log("Message to logger made by factory 3");
        fileLogger3.log("Message to logger made by factory 3");
    }
}
