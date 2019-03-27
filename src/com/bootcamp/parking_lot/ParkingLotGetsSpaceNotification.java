package com.bootcamp.parking_lot;

import java.util.Map;

class ParkingLotGetsSpaceNotification extends Notifiable {
    private static final String notification = "Parking Lot has single space";
    private Integer capacity;

    ParkingLotGetsSpaceNotification(Observer notifier, Integer capacity) {
        super(notifier, notification);
        this.capacity = capacity;
    }

    @Override
    boolean isNotifiable(Map<Token, Car> cars) {
        return cars.size() == this.capacity - 1;
    }
}
