package com.bootcamp.parking_lot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {
    private ParkingLot parkingLot1, parkingLot2;

    @BeforeEach
    void setUp() {
        Attendant attendant = new Attendant();
        parkingLot1 = new ParkingLot(2, attendant);
        parkingLot2 = new ParkingLot(2, attendant);
    }

    @Test
    void shouldReturnTokenWhileParkingCarToParkingLot() throws ParkingLotFullException {
        Car car = new Car();
        Token token = parkingLot1.park(car);
        assertEquals(Token.class, token.getClass());
    }

    @Test
    void shouldThrowExceptionIfParkingACarToAParkingLOtWhichIsFull() throws ParkingLotFullException {
        parkingLot1.park(new Car());
        parkingLot1.park(new Car());
        assertThrows(ParkingLotFullException.class, () -> parkingLot1.park(new Car()));
    }

    @Test
    void shouldCallNotifyForFullParkingMethod() throws ParkingLotFullException {
        MockAttendant mockAttendant = new MockAttendant();
        parkingLot1 = new ParkingLot(2, mockAttendant);

        parkingLot1.park(new Car());
        parkingLot1.park(new Car());

        assertTrue(mockAttendant.isCalledForFullParking);
    }

    @Test
    void shouldReturnTheCarOfTheSameIdWhileUnparkingACar() throws ParkingLotFullException {
        Car car1 = new Car();
        Token token = parkingLot1.park(car1);
        assertEquals(car1, parkingLot1.unPark(token));
    }

    @Test
    void shouldReturnFalseAfterUnparkingACar() {
        assertNull(parkingLot1.unPark(new Token()));
    }

    @Test
    void shouldNotifyWhenFullParkingGetsFree() throws ParkingLotFullException {
        Car car1 = new Car();
        Car car2 = new Car();
        MockAttendant mockAttendant = new MockAttendant();
        ParkingLot parkingLot = new ParkingLot(2, mockAttendant);

        Token tokenForCar1 = parkingLot.park(car1);
        parkingLot.park(car2);
        parkingLot.unPark(tokenForCar1);

        assertTrue(mockAttendant.isCalledForUnparking);
    }

    @Test
    void name() throws ParkingLotFullException {
        Display display = Display.create();
        parkingLot1.park(new Car());
        parkingLot2.park(new Car());
        parkingLot2.park(new Car());
        System.out.println(display.toString());
    }
}

class MockAttendant extends Attendant {
    boolean isCalledForUnparking = false;
    boolean isCalledForFullParking = false;

    @Override
    void notifyForFullParking(ParkingId parkingLotId) {
        this.isCalledForFullParking = true;
    }

    @Override
    void notifyForParkingLotAvailable(ParkingId parkingLotId) {
        this.isCalledForUnparking = true;
    }
}
