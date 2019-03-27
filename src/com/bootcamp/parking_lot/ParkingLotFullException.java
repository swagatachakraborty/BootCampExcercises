package com.bootcamp.parking_lot;

class ParkingLotFullException extends RuntimeException{
    ParkingLotFullException() {
        super("Parking Lot has no available lot");
    }
}
