package com.bootcamp.parking_lot;

class Attendant {
    private final static int increment = 1;
    private final static int decrement = -1;
    private Display display;

    Attendant() {
        this.display = Display.create();
    }

    void notifyParking(ParkingId id, Integer capacity, Integer numberOfCars) {
        if (numberOfCars.equals(capacity - 1))
            this.notifyForFullParking(id);

        this.display.updateDisplay(id, increment);
    }

    void notifyUnparking(ParkingId id, Integer capacity, Integer numberOfCars) {
        if (numberOfCars.equals(capacity))
            this.notifyForParkingLotAvailable(id);

        this.display.updateDisplay(id, decrement);
    }

    void notifyForFullParking(ParkingId id) {
        System.out.printf("Parking lot no. " + id.VALUE + " is full %n");
    }

    void notifyForParkingLotAvailable(ParkingId id) {
        System.out.printf("Parking lot no. " + id.VALUE + " gets a free space %n");
    }
}
