package com.bootcamp.parking_lot;

import java.util.Map;

class UnParkCarNotification extends Notifiable{
    private static final String notification = "Un-park a car";
    private Integer lastCarCount;

    UnParkCarNotification(Observer notifier) {
        super(notifier, notification);
        this.lastCarCount = 0;
    }

    @Override
    boolean isNotifiable(Map<Token, Car> cars) {
        boolean isCarParked = cars.size() < this.lastCarCount;
        this.lastCarCount = cars.size();
        return isCarParked;
    }
}
