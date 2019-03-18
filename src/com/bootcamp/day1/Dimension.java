package com.bootcamp.day1;

public class Dimension {
    private double value;

    public Dimension(double value) throws NegativeDimensionException{
        if(value < 0) {
            throw new NegativeDimensionException();
        }
        this.value = value;
    }

    public double getValue() {
        return this.value;
    }
}
