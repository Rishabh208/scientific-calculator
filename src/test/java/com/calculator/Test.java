package com.calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testSquareRoot() {
        assertEquals(4.0, Calculator.calculateSquareRoot(16), 0.0001);
        assertEquals(0.0, Calculator.calculateSquareRoot(0), 0.0001);
        assertThrows(IllegalArgumentException.class, () -> Calculator.calculateSquareRoot(-1));
    }

    @Test
    void testFactorial() {
        assertEquals(24, Calculator.calculateFactorial(4));  // 4! = 24
        assertEquals(1, Calculator.calculateFactorial(0));
        assertEquals(1, Calculator.calculateFactorial(1));
        assertThrows(IllegalArgumentException.class, () -> Calculator.calculateFactorial(-5));
    }

    @Test
    void testNaturalLogarithm() {
        assertEquals(Math.log(10), Calculator.calculateLogarithm(10), 0.0001);
        assertThrows(IllegalArgumentException.class, () -> Calculator.calculateLogarithm(-5));
    }

    @Test
    void testPowerFunction() {
        assertEquals(8.0, Calculator.calculatePower(2, 3), 0.0001);
        assertEquals(1.0, Calculator.calculatePower(5, 0), 0.0001);
        assertEquals(0.25, Calculator.calculatePower(2, -2), 0.0001);
    }
}
