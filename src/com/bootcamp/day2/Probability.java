package com.bootcamp.day2;

class Probability {
    private double value;

    Probability(double value) throws InvalidRangeException {
        if (!isValid(value)) {
            throw new InvalidRangeException();
        }
        this.value = value;
    }

    private static boolean isValid(double value) {
        return value >= 0 && value <= 1;
    }

    double complement() {
        return 1 - this.value;
    }
}
