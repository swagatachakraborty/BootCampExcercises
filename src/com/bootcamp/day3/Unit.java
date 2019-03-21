package com.bootcamp.day3;

import java.math.BigDecimal;

class Unit {
    private final BigDecimal conversionRatio;

    static final Unit MILLIMETER = new Unit(0.0393701);
    static final Unit CENTIMETER = new Unit(0.393701);
    static final Unit INCH = new Unit(1);
    static final Unit FEET = new Unit(12);

    private Unit(double ratio) {
        this.conversionRatio = new BigDecimal(ratio);
    }

    BigDecimal valueInInches(BigDecimal value) {
        return this.conversionRatio.multiply(value);
    }
}
