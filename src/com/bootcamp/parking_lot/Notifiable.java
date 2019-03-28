package com.bootcamp.parking_lot;

abstract class Notifiable {
    private Observer notifier;
    private Notification notification;

    Notifiable(Observer notifier, Notification notification) {
        this.notifier = notifier;
        this.notification = notification;
    }

    void notify(Integer carSize, Integer capacity, ParkingId ID) {
        if (this.isNotifiable(carSize, capacity))
            this.notifier.notify(this.notification, ID);
    }

    abstract boolean isNotifiable(Integer carSize, Integer capacity);

}


class ParkCarNotifier extends Notifiable {
    private static final Notification notification = new CarParkNotification();
    private Integer lastCarCount;

    ParkCarNotifier(Observer notifier) {
        super(notifier, notification);
        this.lastCarCount = 0;
    }

    @Override
    boolean isNotifiable(Integer carSize, Integer capacity) {
        boolean isCarParked = carSize > this.lastCarCount;
        this.lastCarCount = carSize;
        return isCarParked;
    }
}


class ParkingFullNotifier extends Notifiable {
    private static final Notification notification = new ParkingFullNotification();

    ParkingFullNotifier(Observer notifier) {
        super(notifier, notification);
    }

    @Override
    boolean isNotifiable(Integer carSize, Integer capacity) {
        return carSize.equals(capacity);
    }
}


class SingleSpaceNotifier extends Notifiable {
    private static final Notification notification = new SingleParkingSpaceNotification();

    SingleSpaceNotifier(Observer notifier) {
        super(notifier, notification);
    }

    @Override
    boolean isNotifiable(Integer carSize, Integer capacity) {
        return carSize.equals(capacity - 1);
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
    boolean isNotifiable(Integer carSize, Integer capacity) {
        boolean isCarParked = carSize < this.lastCarCount;
        this.lastCarCount = carSize;
        return isCarParked;
    }
}


class EightyPercentOrMoreSpaceNotifier extends Notifiable {
    private static final Notification notification = new EightyPercentOrMoreSpaceNotification();
    private double ratio;

    EightyPercentOrMoreSpaceNotifier(Observer notifier) {
        super(notifier, notification);
        this.ratio = 0.2;
    }

    @Override
    boolean isNotifiable(Integer carSize, Integer capacity) {
        return (double) carSize / capacity <= this.ratio;
    }
}


class TwentyPercentOrLessSpaceNotifier extends Notifiable {
    private static final Notification notification = new TwentyPercentOrLessSpaceNotification();
    private final double ratio;

    TwentyPercentOrLessSpaceNotifier(Observer notifier) {
        super(notifier, notification);
        this.ratio = 0.8;
    }

    @Override
    boolean isNotifiable(Integer carSize, Integer capacity) {
        return (double) carSize / capacity >= this.ratio;
    }
}
