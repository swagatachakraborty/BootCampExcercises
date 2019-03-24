package com.bootcamp.observerpattern;

public class Main {
    public static void main(String[] args) {
        LoggingSystem loggingSystem = new LoggingSystem();
        ConsoleLogger consoleLogger = new ConsoleLogger();
        FileLogger fileLogger = new FileLogger();

        loggingSystem.addObserver(consoleLogger);
        loggingSystem.addObserver(fileLogger);

        loggingSystem.log("Logging to both Console and File");

        loggingSystem.removeObserver(consoleLogger);
        loggingSystem.log("Logging to File");

        loggingSystem.addObserver(consoleLogger);
        loggingSystem.removeObserver(fileLogger);
        loggingSystem.log("Logging to Console");
    }
}
