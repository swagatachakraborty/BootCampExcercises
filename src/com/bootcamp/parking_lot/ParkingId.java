package com.bootcamp.parking_lot;

class ParkingId {
    private static Integer latestId = 1;
    final String VALUE;

    ParkingId() {
        this.VALUE = create();
    }

    private static String create() {
        return "PL-" + (latestId++);
    }

    @Override
    public String toString() {
        return "ParkingId { " +
                "VALUE = '" + VALUE + '\'' +
                " }";
    }
}
