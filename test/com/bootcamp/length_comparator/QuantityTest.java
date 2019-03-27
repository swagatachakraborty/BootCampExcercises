package com.bootcamp.length_comparator;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class QuantityTest {

  @Test
  void shouldReturnTrueIfTwoFeetAreEqual() {
    Quantity feet1 = new Quantity(new BigDecimal(1), Length.FEET);
    Quantity feet2 = new Quantity(new BigDecimal(1), Length.FEET);
    assertTrue(feet1.compare(feet2));
  }

  @Test
  void shouldReturnFalseIfTwoFeetAreNotEqual() {
    Quantity oneFeet = new Quantity(new BigDecimal(1), Length.FEET);
    Quantity twoFeet = new Quantity(new BigDecimal(2), Length.FEET);
    assertFalse(oneFeet.compare(twoFeet));
  }

  @Test
  void shouldReturnTrueIfTwoInchAreEqual() {
    Quantity inch1 = new Quantity(new BigDecimal(1), Length.INCH);
    Quantity inch2 = new Quantity(new BigDecimal(1), Length.INCH);
    assertTrue(inch1.compare(inch2));
  }

  @Test
  void shouldReturnFalseIfTwoInchAreNotEqual() {
    Quantity oneInch = new Quantity(new BigDecimal(1), Length.INCH);
    Quantity threeInches = new Quantity(new BigDecimal(3), Length.INCH);
    assertFalse(oneInch.compare(threeInches));
  }

  @Test
  void shouldReturnTrueIfFeetIsEqualToInch() {
    Quantity oneFoot = new Quantity(new BigDecimal(1), Length.FEET);
    Quantity twelveInches = new Quantity(new BigDecimal(12), Length.INCH);
    assertTrue(oneFoot.compare(twelveInches));
  }

  @Test
  void shouldReturnFalseIfFeetIsNotEqualToInch() {
    Quantity oneFoot = new Quantity(new BigDecimal(1), Length.FEET);
    Quantity thirteenInches = new Quantity(new BigDecimal(13), Length.INCH);
    assertFalse(oneFoot.compare(thirteenInches));
  }

  @Test
  void shouldReturnTrueIfInchAndCmAreEqual() {
    Quantity fiveCm = new Quantity(new BigDecimal(5), Length.CM);
    Quantity twoInches = new Quantity(new BigDecimal(2), Length.INCH);
    assertTrue(fiveCm.compare(twoInches));
  }

  @Test
  void shouldReturnFalseIfInchAndCmAreNotEqual() {
    Quantity fourCm = new Quantity(new BigDecimal(4), Length.CM);
    Quantity twoInches = new Quantity(new BigDecimal(2), Length.INCH);
    assertFalse(fourCm.compare(twoInches));
  }

  @Test
  void shouldReturnTrueIfCmAndMmAreEqual() {
    Quantity twoInches = new Quantity(new BigDecimal(2), Length.CM);
    Quantity twentyInches = new Quantity(new BigDecimal(20), Length.MM);
    assertTrue(twoInches.compare(twentyInches));
  }

//  @Test
//  void shouldReturnFalseIfCmAndMmAreNotEqual() {
//    Quantity oneCm = new Quantity(new BigDecimal(1), Length.CM);
//    Quantity twentyMm = new Quantity(new BigDecimal(20), Length.MM);
//    assertFalse(oneCm.compare(twentyMm));
//  }

  @Test
  void shouldReturnTrueIfFeetAndMmAreEqual() {
    Quantity oneFoot = new Quantity(new BigDecimal(1), Length.FEET);
    Quantity threeHundredMm = new Quantity(new BigDecimal(300), Length.MM);
    assertTrue(oneFoot.compare(threeHundredMm));
  }

  @Test
  void shouldReturnTrueIfGallonAndLiterAreEqual() {
    Quantity oneGallon = new Quantity(new BigDecimal(1), Volume.GALLON);
    Quantity threeLiter = new Quantity(new BigDecimal(3.78541), Volume.LITER);
    assertTrue(oneGallon.compare(threeLiter));
  }

  @Test
  void shouldReturnFalseIfGallonAndLiterAreNotEqual() {
    Quantity twoGallon = new Quantity(new BigDecimal(2), Volume.GALLON);
    Quantity threeLiter = new Quantity(new BigDecimal(3.78541), Volume.LITER);
    assertFalse(twoGallon.compare(threeLiter));
  }

  @Test
  void shouldNotCompareVolumeToLengthTypeQuantity() {
    Quantity oneLiter = new Quantity<Volume>(new BigDecimal(1), Volume.LITER);
    Quantity oneCm = new Quantity<Length>(new BigDecimal(1000), Volume.GALLON);
    oneLiter.compare(oneCm);
  }

//  @Test
//  void shouldReturnAdditionOfTwoSameQuantity() {
//    Quantity inch1 = new Quantity(new BigDecimal(2), Length.INCH);
//    Quantity inch2 = new Quantity(new BigDecimal(2), Length.INCH);
//    Quantity expected = new Quantity(new BigDecimal(4), Length.INCH);
//    assertEquals(expected, inch1.add(inch2));
//  }

  @Test
  void shouldReturnAdditionOfTwoDifferentLengthInInches() {
    Quantity inch1 = new Quantity(new BigDecimal(2.5), Length.CM);
    Quantity inch2 = new Quantity(new BigDecimal(2), Length.INCH);
    Quantity expected = new Quantity(new BigDecimal(3.0), Length.INCH);
    assertEquals(expected, inch1.add(inch2));
  }

//  @Test
//  void shouldReturnTheAdditionOfGallonAndLiterInLiter() {
//    Quantity oneGallon = new Quantity(new BigDecimal(1), Volume.GALLON);
//    Quantity oneLiter = new Quantity(new BigDecimal(1), Volume.LITER);
//    Quantity expected = new Quantity(new BigDecimal(4.73), Volume.LITER);
//    assertEquals(expected, oneGallon.add(oneLiter));
//  }


  @Test
  void shouldReturnTrueWhenGivenFahrenheitAndCelsiusAreEqual() {
    Quantity fahrenheit = new Quantity(new BigDecimal(212), Temperature.FAHRENHEIT);
    Quantity celsius = new Quantity(new BigDecimal(100), Temperature.CELSIUS);
    assertTrue(fahrenheit.compare(celsius));
  }
}