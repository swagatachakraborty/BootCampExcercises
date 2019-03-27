package com.bootcamp.parking_lot;

import java.util.HashMap;
import java.util.Map;

public class Display {
    private static Display instance;
    private Map<ParkingId, Integer> parkingLotDetails;

    private Display() {
        parkingLotDetails = new HashMap<>();
    }

    static Display create() {
        if (instance == null) instance = new Display();
        return instance;
    }

    void updateDisplay(ParkingId id, Integer delta) {
        parkingLotDetails.putIfAbsent(id, 0);
        Integer totalCars = parkingLotDetails.get(id);
        parkingLotDetails.put(id, totalCars + delta);
    }

    @Override
    public String toString() {
        return "parkingLotDetails = " + parkingLotDetails;
    }
}
