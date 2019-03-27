package com.bootcamp.parking_lot;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class ParkingLot {
    private Map<Token, Car> cars;
    private Set<Notifiable> notifiable;
    final Integer CAPACITY;
    final ParkingId ID;

    ParkingLot(Integer CAPACITY) {
        this.notifiable = new HashSet<>();
        this.CAPACITY = CAPACITY;
        this.cars = new HashMap<>();
        this.ID = new ParkingId();
    }

    private void informNotifiers() {
        for (Notifiable notifier : this.notifiable) {
            notifier.notify(this.cars, this.ID);
        }
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
        this.notifiable.add(notifier);
    }
}
