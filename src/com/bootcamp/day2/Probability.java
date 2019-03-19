package com.bootcamp.day2;

class Probability {
    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 1;
    private double value;

    Probability(double value) throws InvalidRangeException {
        if (!isValid(value)) {
            throw new InvalidRangeException();
        }
        this.value = value;
    }

    private static boolean isValid(double value) {
        return value >= LOWER_BOUND && value <= UPPER_BOUND;
    }

    Probability not() {
        return new Probability(UPPER_BOUND - this.value);
    }

    Probability and(Probability other) {
        return new Probability(this.value * other.value);
    }

    Probability or(Probability other) {
        Probability complementOfThis = this.not();
        Probability complementOfOther = other.not();
        Probability noOccurrence = complementOfThis.and(complementOfOther);
        return noOccurrence.not();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Probability that = (Probability) o;
        return Double.compare(that.value, this.value) == 0;
    }
}
