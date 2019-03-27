package com.bootcamp.parking_lot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {
    private ParkingLot parkingLot1, parkingLot2;

    @BeforeEach
    void setUp() {
        int capacity = 2;
        parkingLot1 = new ParkingLot(capacity);
        parkingLot2 = new ParkingLot(capacity);

        Attendant attendant = new Attendant();
        Assistant assistant = new Assistant();

        ParkingFullNotifier parkingFullNotifier = new ParkingFullNotifier(attendant, capacity);
        SingleSpaceNotifier singleSpaceNotifier = new SingleSpaceNotifier(attendant, capacity);

        ParkCarNotifier parkCarNotifier = new ParkCarNotifier(assistant);
        UnParkCarNotifier unParkCarNotifier = new UnParkCarNotifier(assistant);

        parkingLot1.addNotifier(parkingFullNotifier);
        parkingLot1.addNotifier(singleSpaceNotifier);
        parkingLot1.addNotifier(parkCarNotifier);
        parkingLot1.addNotifier(unParkCarNotifier);

        parkingLot2.addNotifier(parkingFullNotifier);
        parkingLot2.addNotifier(singleSpaceNotifier);
        parkingLot2.addNotifier(parkCarNotifier);
        parkingLot2.addNotifier(unParkCarNotifier);
    }

    @Test
    void shouldReturnTokenWhileParkingCarToParkingLot() throws ParkingLotFullException {
        Car car = new Car();
        Token token = parkingLot1.park(car);
        assertEquals(Token.class, token.getClass());
    }

    @Test
    void shouldThrowExceptionIfParkingACarToAParkingLotWhichIsFull() throws ParkingLotFullException {
        parkingLot1.park(new Car());
        parkingLot1.park(new Car());
        assertThrows(ParkingLotFullException.class, () -> parkingLot1.park(new Car()));
    }

    @Test
    void shouldReturnTheCarOfTheSameIdWhileUnParkingACar() throws ParkingLotFullException {
        Car car1 = new Car();
        Token token = parkingLot1.park(car1);
        assertEquals(car1, parkingLot1.unPark(token));
    }

    @Test
    void UnParkingACarShouldThrowNoSuchTokenExceptionIfTheGivenTokenIsIncorrect() {
        assertThrows(NoSuchTokenException.class, () -> parkingLot1.unPark(new Token()));
    }

    @Test
    void shouldCallNotifyForFullParking() throws ParkingLotFullException {
        MockAttendant mockAttendant = new MockAttendant();
        ParkingLot parkingLot = new ParkingLot(2);
        parkingLot.addNotifier(new ParkingFullNotifier(mockAttendant, parkingLot.CAPACITY));

        parkingLot.park(new Car());
        parkingLot.park(new Car());

        assertTrue(mockAttendant.isNotifyCalled);
    }

    @Test
    void shouldCallNotifyWhenThereIsSingleFreeSpace() throws ParkingLotFullException {
        Car car1 = new Car();
        Car car2 = new Car();
        MockAttendant mockAttendant = new MockAttendant();
        ParkingLot parkingLot = new ParkingLot(2);

        parkingLot.addNotifier(new ParkingFullNotifier(mockAttendant, parkingLot.CAPACITY));

        Token tokenForCar1 = parkingLot.park(car1);
        parkingLot.park(car2);
        parkingLot.unPark(tokenForCar1);

        assertTrue(mockAttendant.isNotifyCalled);
    }

    @Test
    void displayShouldPrintTheCurrentStatusOfParkingLotsToTheConsole() throws ParkingLotFullException {
        Display display = Display.create();
        parkingLot1.park(new Car());
        parkingLot2.park(new Car());
        parkingLot2.park(new Car());
        System.out.println(display.toString());
    }
}

class MockAttendant extends Attendant {
    boolean isNotifyCalled = false;

    @Override
    public void notify(Notification notification, ParkingId id) {
        this.isNotifyCalled = true;
    }
}
