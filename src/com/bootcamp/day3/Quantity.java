package com.bootcamp.day3;

import java.math.BigDecimal;

class Quantity {
    private BigDecimal value;
    private Unit unit;

    Quantity(double value, Unit unit) {
        this.value = BigDecimal.valueOf(value);
        this.unit = unit;
    }

    boolean isEqual(Quantity other) {
        return this.valueInBaseUnit().equals(other.valueInBaseUnit());

    }

    private BigDecimal valueInBaseUnit() {
        double baseValueInDouble = this.unit.valueInInches(this.value).doubleValue();
        long baseValueInLong = Math.round(baseValueInDouble);
        return BigDecimal.valueOf(baseValueInLong);
    }
}
