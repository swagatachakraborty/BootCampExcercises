package com.bootcamp.observerpattern;

interface Observable {

    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObserver();
}
