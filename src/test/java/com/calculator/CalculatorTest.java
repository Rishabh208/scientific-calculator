package com.calculator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void testAddition() {
        assertEquals(5.0, calculator.add(2, 3), 0.0001);
        assertEquals(-1.0, calculator.add(-2, 1), 0.0001);
    }

    @Test
    void testSubtraction() {
        assertEquals(4.0, calculator.subtract(7, 3), 0.0001);
        assertEquals(-3.0, calculator.subtract(-2, 1), 0.0001);
    }

    @Test
    void testMultiplication() {
        assertEquals(6.0, calculator.multiply(2, 3), 0.0001);
        assertEquals(-10.0, calculator.multiply(-2, 5), 0.0001);
    }

    @Test
    void testDivision() {
        assertEquals(2.0, calculator.divide(6, 3), 0.0001);
        assertEquals(-4.0, calculator.divide(-8, 2), 0.0001);
    }

    @Test
    void testDivisionByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> calculator.divide(5, 0));
        assertEquals("Cannot divide by zero", exception.getMessage());
    }

    @Test
    void testPower() {
        assertEquals(8.0, calculator.power(2, 3), 0.0001);
        assertEquals(0.25, calculator.power(2, -2), 0.0001);
    }

    @Test
    void testSquareRoot() {
        assertEquals(4.0, calculator.sqrt(16), 0.0001);
        assertEquals(3.0, calculator.sqrt(9), 0.0001);
    }

    @Test
    void testSquareRootOfNegativeNumber() {
        Exception exception = assertThrows(ArithmeticException.class, () -> calculator.sqrt(-4));
        assertEquals("Cannot compute square root of negative number", exception.getMessage());
    }
}
