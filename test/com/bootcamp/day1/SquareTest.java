package com.bootcamp.day1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {
    Square sqr;
    @BeforeEach
    void setUp() throws NegativeDimensionException {
        sqr = new Square(new Dimension(2));
    }

    @Test
    void calculateArea() {
        double areaOfSquare = sqr.calculateArea();
        assertEquals(4,areaOfSquare,1);
    }

    @Test
    void calculatePerimeter() {
        double perimeterOfSquare = sqr.calculatePerimeter();
        assertEquals(8,perimeterOfSquare,1);
    }
}