package com.bootcamp.length_comparator;

import java.math.BigDecimal;
import java.math.MathContext;

class Volume extends Unit<Volume> {
  static final Volume GALLON = new Volume(new BigDecimal(3.78541));
  static final Volume LITER = new Volume(new BigDecimal(1));

  private BigDecimal ratio;

  private Volume(BigDecimal ratio) {
    super(LITER);
    this.ratio = ratio;
  }

  @Override
  public BigDecimal convertToBase(BigDecimal value) {
    return this.ratio.multiply(value).round(new MathContext(3));
  }
}
