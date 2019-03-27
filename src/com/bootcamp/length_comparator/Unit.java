package com.bootcamp.length_comparator;

import java.math.BigDecimal;

abstract class Unit<T extends  Unit> {
  Unit STANDARD;

  Unit(Unit STANDARD) {
    this.STANDARD = STANDARD;
  }

  abstract BigDecimal convertToBase(BigDecimal value);
}
