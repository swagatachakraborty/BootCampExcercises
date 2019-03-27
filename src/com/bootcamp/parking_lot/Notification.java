package com.bootcamp.parking_lot;

abstract class Notification {
    final String MESSAGE;

    Notification(String message) {
        this.MESSAGE = message;
    }

}

class ParkingFullNotification extends Notification {
    ParkingFullNotification() {
        super("Parking Lot is full");
    }
}

class CarParkNotification extends Notification {
    CarParkNotification() {
        super("Park a car");
    }
}

class CarUnParkNotification extends Notification {
    CarUnParkNotification() {
        super("Un-park a car");
    }
}

class SingleParkingSpaceNotification extends Notification {
    SingleParkingSpaceNotification() {
        super("Parking Lot has single space");
    }
}
