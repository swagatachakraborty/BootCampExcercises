package com.bootcamp.parking_lot;

import java.util.HashSet;
import java.util.Set;

class ParkingLot {
    private static Integer latestId = 1;
    private Set<Car> cars;
    private Attendant attendant;
    private Integer capacity;
    private Integer id;

    ParkingLot(Integer capacity, Attendant attendant) {
        this.capacity = capacity;
        this.cars = new HashSet<>();
        this.attendant = attendant;
        this.id = latestId;
        latestId++;
    }

    boolean park(Car car) {
        if (this.cars.size() == capacity) return false;
        if (this.cars.size() == capacity - 1) this.attendant.notifyForFullParking(this.id);

        return this.cars.add(car);
    }

    boolean unPark(Car car) {
        if (this.cars.size() == this.capacity)
            this.attendant.notifyWhenFullParkingGetsFree(this.id);

        return this.cars.remove(car);
    }
}
