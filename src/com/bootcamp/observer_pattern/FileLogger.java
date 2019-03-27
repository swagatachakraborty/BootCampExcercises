package com.bootcamp.observer_pattern;

class FileLogger implements Observer {
    @Override
    public String notify(String message) {
        System.out.println("Logging to file: " + message);
        return "file";
    }
}
