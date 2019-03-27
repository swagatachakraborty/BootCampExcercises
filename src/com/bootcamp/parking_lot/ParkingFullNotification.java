package com.bootcamp.parking_lot;

import java.util.Map;

class ParkingFullNotification extends Notifiable {
    private static final String notification = "Parking Lot is full";
    private Integer capacity;

    ParkingFullNotification(Observer notifier, Integer capacity) {
        super(notifier, notification);
        this.capacity = capacity;
    }

    @Override
    boolean isNotifiable(Map<Token, Car> cars) {
        return cars.size() == this.capacity;
    }
}
