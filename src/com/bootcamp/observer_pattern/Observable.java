package com.bootcamp.observer_pattern;

interface Observable {

    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObserver();
}
