package com.bootcamp.matrix;

import com.bootcamp.day1.NegativeDimensionException;

class PositiveInteger {

    private final Integer value;

    private PositiveInteger(int value) {
        this.value = value;
    }

    static PositiveInteger create(int value) throws NegativeDimensionException {
        if(value<0){
            throw new NegativeDimensionException();
        }
        return new PositiveInteger(value);
    }

    int getValue() {
        return this.value;
    }
}
