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

        Observer attendant = new Attendant();
        Observer assistant = new Assistant();
        Observer civicBody = new CivicBody();

        Notifiable parkingFullNotifier = new ParkingFullNotifier(attendant);
        Notifiable singleSpaceNotifier = new SingleSpaceNotifier(attendant);
        Notifiable eightyPercentOrMoreSpaceNotifier = new EightyPercentOrMoreSpaceNotifier(attendant);

        Notifiable parkCarNotifier = new ParkCarNotifier(assistant);
        Notifiable unParkCarNotifier = new UnParkCarNotifier(assistant);

        Notifiable twentyPercentOrLessSpaceNotifier = new TwentyPercentOrLessSpaceNotifier(civicBody);

        parkingLot1.addNotifier(parkingFullNotifier);
        parkingLot1.addNotifier(singleSpaceNotifier);
        parkingLot1.addNotifier(parkCarNotifier);
        parkingLot1.addNotifier(unParkCarNotifier);
        parkingLot1.addNotifier(eightyPercentOrMoreSpaceNotifier);
        parkingLot1.addNotifier(twentyPercentOrLessSpaceNotifier);

        parkingLot2.addNotifier(parkingFullNotifier);
        parkingLot2.addNotifier(singleSpaceNotifier);
        parkingLot2.addNotifier(parkCarNotifier);
        parkingLot2.addNotifier(unParkCarNotifier);
        parkingLot2.addNotifier(eightyPercentOrMoreSpaceNotifier);
        parkingLot2.addNotifier(twentyPercentOrLessSpaceNotifier);
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
        int capacity = 2;
        ParkingLot parkingLot = new ParkingLot(capacity);
        parkingLot.addNotifier(new ParkingFullNotifier(mockAttendant));

        parkingLot.park(new Car());
        parkingLot.park(new Car());

        assertTrue(mockAttendant.isNotifyCalled);
    }

    @Test
    void shouldCallNotifyWhenThereIsSingleFreeSpace() throws ParkingLotFullException {
        Car car1 = new Car();
        Car car2 = new Car();
        MockAttendant mockAttendant = new MockAttendant();
        int capacity = 2;
        ParkingLot parkingLot = new ParkingLot(capacity);
        parkingLot.addNotifier(new ParkingFullNotifier(mockAttendant));

        Token tokenForCar1 = parkingLot.park(car1);
        parkingLot.park(car2);
        parkingLot.unPark(tokenForCar1);

        assertTrue(mockAttendant.isNotifyCalled);
    }

    @Test
    void shouldCallNotifyOfAssistantWhileParkingACar() {
        MockAssistant mockAssistant = new MockAssistant();
        int capacity = 2;
        ParkingLot parkingLot = new ParkingLot(capacity);
        parkingLot.addNotifier(new ParkCarNotifier(mockAssistant));

        parkingLot.park(new Car());

        assertTrue(mockAssistant.isNotifyCalled);
    }

    @Test
    void shouldCallNotifyOfAssistantWhileUnParkingACar() {
        MockAssistant mockAssistant = new MockAssistant();
        int capacity = 2;
        ParkingLot parkingLot = new ParkingLot(capacity);
        parkingLot.addNotifier(new UnParkCarNotifier(mockAssistant));

        Car car = new Car();
        Token token = parkingLot.park(car);
        mockAssistant.isNotifyCalled = false; // reset isNotifyCalled to false after parking.
        parkingLot.unPark(token);

        assertTrue(mockAssistant.isNotifyCalled);
    }

    @Test
    void shouldNotifyAttendantWhenTheLotGot80PercentEmpty() {
        MockAttendant mockAttendant = new MockAttendant();
        int capacity = 10;
        ParkingLot parkingLot = new ParkingLot(capacity);
        parkingLot.addNotifier(new EightyPercentOrMoreSpaceNotifier(mockAttendant));

        Car car = new Car();
        parkingLot.park(car);
        parkingLot.park(new Car());

        assertTrue(mockAttendant.isNotifyCalled);
    }

    @Test
    void shouldNotifyAttendantWhenTheLotGotMoreThan80PercentEmpty() {
        MockAttendant mockAttendant = new MockAttendant();
        int capacity = 10;
        ParkingLot parkingLot = new ParkingLot(capacity);
        parkingLot.addNotifier(new EightyPercentOrMoreSpaceNotifier(mockAttendant));

        Car car = new Car();
        parkingLot.park(car);

        assertTrue(mockAttendant.isNotifyCalled);
    }


    @Test
    void shouldNotifyCivicBodyWhenTheLotGot20PercentEmpty() {
        MockCivicBody mockCivicBody = new MockCivicBody();
        int capacity = 10;
        ParkingLot parkingLot = new ParkingLot(capacity);
        parkingLot.addNotifier(new TwentyPercentOrLessSpaceNotifier(mockCivicBody));

        parkingLot.park(new Car());
        parkingLot.park(new Car());
        parkingLot.park(new Car());
        parkingLot.park(new Car());
        parkingLot.park(new Car());
        parkingLot.park(new Car());
        parkingLot.park(new Car());
        parkingLot.park(new Car());

        assertTrue(mockCivicBody.isNotifyCalled);
    }

    @Test
    void shouldNotifyCivicBodyWhenTheLotGotLessThan20PercentEmpty() {
        MockCivicBody mockCivicBody = new MockCivicBody();
        int capacity = 4;
        ParkingLot parkingLot = new ParkingLot(capacity);
        parkingLot.addNotifier(new TwentyPercentOrLessSpaceNotifier (mockCivicBody));

        parkingLot.park(new Car());
        parkingLot.park(new Car());
        parkingLot.park(new Car());
        parkingLot.park(new Car());

        assertTrue(mockCivicBody.isNotifyCalled);
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


class MockAssistant extends Assistant {
    boolean isNotifyCalled = false;

    @Override
    public void notify(Notification notification, ParkingId id) {
        this.isNotifyCalled = true;
    }
}


class MockCivicBody extends CivicBody {
    boolean isNotifyCalled = false;

    @Override
    public void notify(Notification notification, ParkingId id) {
        this.isNotifyCalled = true;
    }
}
