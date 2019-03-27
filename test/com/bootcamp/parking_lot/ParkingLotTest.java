package com.bootcamp.parking_lot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {
    private ParkingLot parkingLot1, parkingLot2;
    private Attendant attendant;

    @BeforeEach
    void setUp() {
        attendant = new Attendant();
        parkingLot1 = new ParkingLot(2, attendant);
        parkingLot2 = new ParkingLot(2, attendant);
    }

    @Test
    void shouldReturnTrueAfterParkingACar() {
        Car car = new Car();
        assertTrue(parkingLot1.park(car));
    }

    @Test
    void shouldReturnFalseIfParkingACarToAParkingLOtWhichIsFull() {
        parkingLot1.park(new Car());
        parkingLot1.park(new Car());
        assertFalse(parkingLot1.park(new Car()));
    }

    @Test
    void shouldCallNotifyForFullParkingMethod() {
        MockAttendant mockAttendant = new MockAttendant();
        parkingLot1 = new ParkingLot(2, mockAttendant);

        parkingLot1.park(new Car());
        parkingLot1.park(new Car());

        assertTrue(mockAttendant.isCalledForFullParking);
    }

    @Test
    void shouldReturnTheCarOfTheSameIdWhileUnparkingACar() {
        Car car1 = new Car();
        parkingLot1.park(car1);
        assertEquals(car1, parkingLot1.unPark(car1.getId()));
    }

    @Test
    void shouldReturnFalseAfterUnparkingACar() {
        Car car1 = new Car();
        assertNull(parkingLot1.unPark(car1.getId()));
    }

    @Test
    void shouldNotifyWhenFullParkingGetsFree() {
        Car car1 = new Car();
        Car car2 = new Car();
        MockAttendant mockAttendant = new MockAttendant();
        ParkingLot parkingLot = new ParkingLot(2, mockAttendant);

        parkingLot.park(car1);
        parkingLot.park(car2);
        parkingLot.unPark(car1.getId());

        assertTrue(mockAttendant.isCalledForUnparking);
    }
}

class MockAttendant extends Attendant {
    boolean isCalledForUnparking = false;
    boolean isCalledForFullParking = false;

    @Override
    void notifyForFullParking(Integer parkingLotId) {
        this.isCalledForFullParking = true;
    }

    @Override
    void notifyWhenFullParkingGetsFree(Integer parkingLotId) {
        this.isCalledForUnparking = true;
    }
}
