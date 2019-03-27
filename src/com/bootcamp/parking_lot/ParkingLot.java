package com.bootcamp.parking_lot;

import java.util.HashMap;
import java.util.Map;

class ParkingLot {
    private Map<Token, Car> cars;
    private Attendant attendant;
    private Integer capacity;
    private ParkingId id;

    ParkingLot(Integer capacity, Attendant attendant) {
        this.capacity = capacity;
        this.cars = new HashMap<>();
        this.attendant = attendant;
        this.id = new ParkingId();
    }

    Token park(Car car) throws ParkingLotFullException {
        if (this.cars.size() == capacity) throw new ParkingLotFullException();

        this.attendant.notifyParking(this.id, capacity, this.cars.size());

        Token token = new Token();
        this.cars.put(token, car);
        return token;
    }

    Car unPark(Token token) {
        this.attendant.notifyUnparking(this.id, capacity, this.cars.size());

        return cars.remove(token);
    }
}
