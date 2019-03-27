package com.bootcamp.observer_pattern;

class ConsoleLogger implements Observer{
    @Override
    public String notify(String message) {
        System.out.println("Logging to console: " + message);
        return "console";
    }
}
