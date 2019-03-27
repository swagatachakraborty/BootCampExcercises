package com.bootcamp.length_comparator;

import java.math.BigDecimal;

public class Temperature extends Unit<Temperature>{

  static Temperature FAHRENHEIT = new Temperature(new BigDecimal(0.56),new BigDecimal(32));
  static Temperature CELSIUS = new Temperature(new BigDecimal(1),new BigDecimal(0));
  private BigDecimal ratio;
  private BigDecimal scale;

  private Temperature(BigDecimal ratio, BigDecimal scale) {
    super(CELSIUS);
    this.ratio = ratio;
    this.scale = scale;
  }

  @Override
  public BigDecimal convertToBase(BigDecimal value) {
    return BigDecimal.valueOf(value.subtract(this.scale).multiply(this.ratio).intValue());
  }
}
