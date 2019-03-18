package com.bootcamp.day1;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DimensionTest {

    @Test
    @DisplayName("Should create instance of Dimension when the given value is positive")
    void creatingDimensionForValidValue() throws NegativeDimensionException {
        Dimension dimension = new Dimension(10);
        assertEquals(10, dimension.getValue());
    }


    @Test
    @DisplayName("Should through exception for create instance of Dimension when the given value is negative")
    void creatingDimensionForInvalidValue() {
        assertThrows(Exception.class, () -> new Dimension(-10));
    }
}