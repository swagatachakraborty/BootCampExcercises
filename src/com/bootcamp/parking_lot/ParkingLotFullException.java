package com.bootcamp.parking_lot;

class ParkingLotFullException extends Exception{
    ParkingLotFullException() {
        super("Parking Lot has no available lot");
    }
}
