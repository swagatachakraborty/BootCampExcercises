package com.bootcamp.parking_lot;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class ParkingLot {
    private final Integer CAPACITY;
    private final ParkingId ID;
    private Map<Token, Car> cars;
    private Set<Notifiable> notifiers;

    ParkingLot(Integer capacity) {
        this.notifiers = new HashSet<>();
        this.CAPACITY = capacity;
        this.cars = new HashMap<>();
        this.ID = new ParkingId();
    }

    Token park(Car car) throws ParkingLotFullException {
        if (this.cars.size() == this.CAPACITY) throw new ParkingLotFullException();

        Token token = new Token();
        this.cars.put(token, car);

        this.informNotifiers();

        return token;
    }

    Car unPark(Token token) throws NoSuchTokenException {
        if (!cars.containsKey(token)) throw new NoSuchTokenException();

        Car unParkCar = cars.remove(token);
        this.informNotifiers();

        return unParkCar;
    }

    void addNotifier(Notifiable notifier) {
        this.notifiers.add(notifier);
    }

    private void informNotifiers() {
        for (Notifiable notifier : this.notifiers) {
            notifier.notify(this.cars.size(), this.CAPACITY, this.ID);
        }
    }
}
