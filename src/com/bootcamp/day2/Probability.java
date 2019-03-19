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

    Probability complement() {
        return new Probability(1 - this.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Probability that = (Probability) o;
        return Double.compare(that.value, value) == 0;
    }
}

