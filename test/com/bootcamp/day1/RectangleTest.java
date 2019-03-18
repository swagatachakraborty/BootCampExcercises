package com.bootcamp.day1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RectangleTest {
    private Rectangle rectangle;

    @BeforeEach
    void setUp() throws NegativeDimensionException {
        Dimension length = new Dimension(20);
        Dimension breadth = new Dimension(10);
        rectangle = new Rectangle(length,breadth);
    }

    @Test
    @DisplayName("Should return the calculated area of rectangle of provided length and breadth")
    void calculateArea() {
        double areaOfRectangle = rectangle.calculateArea();
        assertEquals(200, areaOfRectangle,1);
    }

    @Test
    @DisplayName("Should return the calculated perimeter of rectangle of provided length and breadth")
    void calculatePerimeter() {
        double perimeterOfRectangle = rectangle.calculatePerimeter();
        assertEquals(60, perimeterOfRectangle,1);
    }
}
