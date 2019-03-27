package com.bootcamp.parking_lot;

import java.util.Map;

abstract class Notifiable {
    private Observer notifier;
    private Notification information;

    Notifiable(Observer notifier, Notification information) {
        this.notifier = notifier;
        this.information = information;
    }

    void inform(Map<Token, Car> cars, ParkingId ID) {
        if (this.isNotifiable(cars))
            this.notifier.notify(this.information, ID);
    }

    abstract boolean isNotifiable(Map<Token, Car> cars);

}


class ParkCarNotifier extends Notifiable {
    private static final Notification notification = new CarParkNotification();
    private Integer lastCarCount;

    ParkCarNotifier(Observer notifier) {
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


class ParkingFullNotifier extends Notifiable {
    private static final Notification notification = new ParkingFullNotification();
    private Integer capacity;

    ParkingFullNotifier(Observer notifier, Integer capacity) {
        super(notifier, notification);
        this.capacity = capacity;
    }

    @Override
    boolean isNotifiable(Map<Token, Car> cars) {
        return cars.size() == this.capacity;
    }
}


class SingleSpaceNotifier extends Notifiable {
    private static final Notification notification = new SingleParkingSpaceNotification();
    private Integer capacity;

    SingleSpaceNotifier(Observer notifier, Integer capacity) {
        super(notifier, notification);
        this.capacity = capacity;
    }

    @Override
    boolean isNotifiable(Map<Token, Car> cars) {
        return cars.size() == this.capacity - 1;
    }
}


class UnParkCarNotifier extends Notifiable {
    private static final Notification notification = new CarUnParkNotification();
    private Integer lastCarCount;

    UnParkCarNotifier(Observer notifier) {
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
