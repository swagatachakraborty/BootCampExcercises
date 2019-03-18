package com.bootcamp.day1;

public class NegativeDimensionException extends Exception {
    public NegativeDimensionException() {
        super("Dimension can't be negative");
    }
}
