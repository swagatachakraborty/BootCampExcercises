package com.bootcamp.parking_lot;

interface Observer {
    void notify(Notification message, ParkingId id);
}


class Assistant implements Observer {
    private final static int increment = 1;
    private final static int decrement = -1;
    private Display display;

    Assistant() {
        this.display = Display.create();
    }

    @Override
    public void notify(Notification notification, ParkingId id) {
        System.out.println(notification.MESSAGE + " - " + id);

        this.updateDisplay(notification, id);
    }

    private void updateDisplay(Notification notification, ParkingId id) {
        if (notification.getClass() == CarParkNotification.class) {
            this.display.updateDisplay(id, increment);
            return;
        }

        this.display.updateDisplay(id, decrement);
    }
}


class Attendant implements Observer {
    @Override
    public void notify(Notification notification, ParkingId id) {
        System.out.println(notification.MESSAGE + " - " + id);
    }
}


class CivicBody implements Observer {
    @Override
    public void notify(Notification notification, ParkingId id) {
        System.out.println(notification.MESSAGE + " - " + id);
    }
}

