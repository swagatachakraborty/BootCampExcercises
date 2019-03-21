package com.bootcamp.day3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class QuantityTest {

    @Test
    void isEqualShouldReturnTrueForTwoEqualFeets() {
        Quantity oneFoot = new Quantity(1, Unit.FEET);
        Quantity anotherOneFoot = new Quantity(1, Unit.FEET);
        assertTrue(oneFoot.isEqual(anotherOneFoot));
    }

    @Test
    void isEqualShouldReturnTrueForTwoEqualFeetAndInches() {
        Quantity oneFoot = new Quantity(1, Unit.FEET);
        Quantity twelveInches = new Quantity(12, Unit.INCH);
        assertTrue(oneFoot.isEqual(twelveInches));
    }

    @Test
    void isEqualShouldReturnTrueForCMOfEqualInch() {
        Quantity oneCM = new Quantity(5, Unit.CENTIMETER);
        Quantity inches = new Quantity(2, Unit.INCH);
        assertTrue(oneCM.isEqual(inches));
    }

    @Test
    void isEqualShouldReturnTrueForCMOfEqualMillimeter() {
        Quantity oneCM = new Quantity(5, Unit.CENTIMETER);
        Quantity inches = new Quantity(50, Unit.MILLIMETER);
        assertTrue(oneCM.isEqual(inches));
    }
}
