package com.bootcamp.observerpattern;

class ConsoleLogger implements Observer{
    @Override
    public String notify(String message) {
        System.out.println("Logging to console: " + message);
        return "console";
    }
}
