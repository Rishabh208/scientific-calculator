package com.calculator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    @Test
    void testSquareRoot() {
        assertEquals(4.0, Calculator.calculateSquareRoot(16), 0.0001);
        assertEquals(0.0, Calculator.calculateSquareRoot(0), 0.0001);
    }

    @Test
    void testFactorial() {
        assertEquals(20, Calculator.calculateFactorial(4));
        assertEquals(1, Calculator.calculateFactorial(0));
        assertEquals(1, Calculator.calculateFactorial(1));
    }

    @Test
    void testNaturalLogarithm() {
        assertEquals(Math.log(10), Calculator.calculateLogarithm(10), 0.0001);
    }

    @Test
    void testPowerFunction() {
        assertEquals(8.0, Calculator.calculatePower(2, 3), 0.0001);
        assertEquals(1.0, Calculator.calculatePower(5, 0), 0.0001);
        assertEquals(0.25, Calculator.calculatePower(2, -2), 0.0001);
    }
}
