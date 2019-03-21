package com.bootcamp.day3;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UnitTest {

    @Test
    void convertToInchesForFeet() {
        BigDecimal expected = BigDecimal.valueOf(12);
        BigDecimal actual = Unit.FEET.valueInInches(BigDecimal.valueOf(1));
        assertEquals(expected, actual);
    }
}
