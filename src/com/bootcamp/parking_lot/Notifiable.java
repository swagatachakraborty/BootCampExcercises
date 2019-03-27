package com.bootcamp.parking_lot;

import java.util.Map;

abstract class Notifiable {
    private Observer notifier;
    private String information;

    Notifiable(Observer notifier, String information) {
        this.notifier = notifier;
        this.information = information;
    }

    void inform(Map<Token, Car> cars) {
        if(this.isNotifiable(cars))
        this.notifier.inform(this.information);
    }

    abstract boolean isNotifiable(Map<Token, Car> cars);
}

