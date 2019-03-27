package com.bootcamp.observer_pattern;

import java.util.ArrayList;
import java.util.List;

class LoggingSystem implements Observable {
    private String lastMessege;
    private List<Observer> observerList;

    LoggingSystem() {
        this.lastMessege = "";
        this.observerList = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObserver() {
        observerList.forEach(observer -> observer.notify(this.lastMessege));
    }

    void log(String message) {
        this.lastMessege = message;
        this.notifyObserver();
    }
}
