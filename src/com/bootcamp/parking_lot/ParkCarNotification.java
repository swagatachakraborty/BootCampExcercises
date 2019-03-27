package com.bootcamp.parking_lot;

import java.util.Map;

class ParkCarNotification extends Notifiable {
    private static final String notification = "Park a car";
    private Integer lastCarCount;

    ParkCarNotification(Observer notifier) {
        super(notifier, notification);
        this.lastCarCount = 0;
    }

    @Override
    boolean isNotifiable(Map<Token, Car> cars) {
        boolean isCarParked = cars.size() > this.lastCarCount;
        this.lastCarCount = cars.size();
        return isCarParked;
    }
}
