package com.example;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class FactorialTestNG {

    @Test
    public void testFactorialOfZero() {
        assertEquals(Factorial.calculateFactorial(0), 1);
    }

    @Test
    public void testFactorialOfPositiveNumber() {
        assertEquals(Factorial.calculateFactorial(5), 120);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialOfNegativeNumber() {
        Factorial.calculateFactorial(-1);
    }
}
