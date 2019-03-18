package com.bootcamp.day1;

public class Rectangle {
    private double length;
    private double breadth;

    public Rectangle(Dimension length, Dimension breadth) {
        this.length = length.getValue();
        this.breadth = breadth.getValue();
    }

    public double calculateArea() {
        return this.length * this.breadth;
    }

    public double calculatePerimeter() {
        return 2 * (this.length + this.breadth);
    }
}
