package com.bootcamp.length_comparator;


import java.math.BigDecimal;
import java.util.Objects;

class Quantity<T extends Unit<T>> {
  private final BigDecimal value;
  private final Unit<T> unit;

  Quantity(BigDecimal value, Unit unit) {
    this.value = value;
    this.unit = unit;
  }

  boolean compare(Quantity<T> other) {
    return this.unit.convertToBase(this.value).equals(other.unit.convertToBase(other.value));
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof Quantity)) return false;
    if (this == other) return true;
    if (this.getClass() != other.getClass()) return false;
    Quantity quantity = (Quantity) other;
    return Objects.equals(value, quantity.value) &&
            Objects.equals(unit, quantity.unit);
  }

  Quantity add(Quantity other) {
    BigDecimal thisQuantityInBase = this.unit.convertToBase(this.value);
    BigDecimal otherQuantityInBase = other.unit.convertToBase(other.value);
    return new Quantity(thisQuantityInBase.add(otherQuantityInBase), unit.STANDARD);
  }
}
