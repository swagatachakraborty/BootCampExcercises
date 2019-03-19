package com.bootcamp.day2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ProbabilityTest {

    private Probability expected;

    @Test
    @DisplayName("should throw InvalidRangeException when the provided probability is less than 0.")
    void invalidRangeExceptionForLessThanZero() {
        InvalidRangeException invalidRangeException = assertThrows(InvalidRangeException.class, () -> new Probability(-1));
        assertEquals("Invalid Range", invalidRangeException.getMessage());
    }

    @Test
    @DisplayName("should throw InvalidRangeException when the provided probability is greater than 1.")
    void invalidRangeExceptionForGreaterThanOne() {
        InvalidRangeException invalidRangeException = assertThrows(InvalidRangeException.class, () -> new Probability(1.1));
        assertEquals("Invalid Range", invalidRangeException.getMessage());
    }

    @Test
    @DisplayName("should not throw invalidRangeException when probability lies between 0 to 1")
    void validProbability() {
        assertDoesNotThrow(() -> new Probability(0.1));
    }

    @Test
    @DisplayName("should give the complement of the given probability")
    void complement() {
        Probability probability = new Probability(0.5);

        expected = new Probability(0.5);
        assertEquals(expected, probability.complement());
    }
}
