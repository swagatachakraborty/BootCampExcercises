package com.bootcamp.parking_lot;

class Car {
    private Integer id;
    private static Integer latestCarId = 1;

    Car() {
        this.id = latestCarId;
        latestCarId++;
    }

    Integer getId() {
        return this.id;
    }
}
