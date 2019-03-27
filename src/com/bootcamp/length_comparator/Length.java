package com.bootcamp.length_comparator;

import java.math.BigDecimal;

class Length extends Unit<Length> {
  static Length FEET = new Length(new BigDecimal(12));
  static Length INCH = new Length(new BigDecimal(1));

  static Length CM = new Length(new BigDecimal(0.4));
  static Length MM = new Length(new BigDecimal(0.04));
  private BigDecimal ratio;

  private Length(BigDecimal ratio) {
    super(INCH);
    this.ratio = ratio;
  }

  @Override
  public BigDecimal convertToBase(BigDecimal value) {
    return BigDecimal.valueOf(this.ratio.multiply(value).intValue());
  }
}
