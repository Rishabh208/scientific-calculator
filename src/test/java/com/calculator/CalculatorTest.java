package com.calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private final Calculator calc = new Calculator();

    @Test
    public void testAddition() {
        assertEquals(5.0, calc.add(2, 3));
    }

    @Test
    public void testSubtraction() {
        assertEquals(1.0, calc.subtract(4, 3));
    }

    @Test
    public void testMultiplication() {
        assertEquals(12.0, calc.multiply(4, 3));
    }

    @Test
    public void testDivision() {
        assertEquals(2.0, calc.divide(6, 3));
    }

    @Test
    public void testPower() {
        assertEquals(8.0, calc.power(2, 3));
    }

    @Test
    public void testSqrt() {
        assertEquals(3.0, calc.sqrt(9));
    }
}

