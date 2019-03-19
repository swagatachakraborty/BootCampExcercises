package com.bootcamp.day2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProbabilityTest {

    @Test
    @DisplayName("should throw InvalidRangeException when the provided probability is less than 0")
    void invalidRangeExceptionForLessThanZero() {
        InvalidRangeException invalidRangeException = assertThrows(InvalidRangeException.class, () -> new Probability(-1));
        assertEquals("Invalid Range", invalidRangeException.getMessage());
    }

    @Test
    @DisplayName("should throw InvalidRangeException when the provided probability is greater than 1")
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
    @DisplayName("should give the not of the given probability")
    void complement() {
        Probability probability = new Probability(0.5);
        Probability expected = new Probability(0.5);
        assertEquals(expected, probability.not());
    }

    @Test
    @DisplayName("Should return the probability of co-occurrence of two tails while flipping two coins")
    void coOccurrenceOfTwoTails() {
        Probability probabilityOfCoin1 = new Probability(0.5);
        Probability probabilityOfCoin2 = new Probability(0.5);
        Probability expected = new Probability(0.25);
        assertEquals(expected, probabilityOfCoin1.and(probabilityOfCoin2));

    }

    @Test
    @DisplayName("Should return the probability of at least single occurrence of tail while flipping two coins")
    void atLeastSingleOccurrenceOfTails() {
        Probability probabilityOfCoin1 = new Probability(0.5);
        Probability probabilityOfCoin2 = new Probability(0.5);
        Probability expected = new Probability(0.75);
        assertEquals(expected, probabilityOfCoin1.or(probabilityOfCoin2));
    }
}
