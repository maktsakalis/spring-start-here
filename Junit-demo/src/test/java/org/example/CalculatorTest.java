package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class CalculatorTest {

    Calculator calculator;

    @Before
    public void setup() {
        //arrange
        calculator = new Calculator();
    }

    @Test
    public void testAdd() {
        //arrange
        int a = 10;
        int b = 20;

        //act
        int result = calculator.add(a, b);

        //assert
        assertEquals(result, 30);
    }

    @Test
    public void testFail() {
        try {
            assertEquals(5 / 5, 1);
        } catch (Exception exception) {
            fail("Intended failure!");
        }
    }

    @Test(expected = RuntimeException.class)
    public void testException() {
        throw new RuntimeException("Ooops!");
    }
}