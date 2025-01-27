package com.belajartestng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest {

    @Test
    public void addTest() {
        int actualResult = Calculator.add(10, 20);
        int expectedResult = 30;

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void subTest() {
        int actualResult = Calculator.subtract(10, 20);
        int expectedResult = -10;

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void multiplyTest() {
        int actualResult = Calculator.multiply(10, 2);
        int expectedResult = 20;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void divideTest() {
        int actualResult = Calculator.divide(40, 20);
        int expectedResult = 2;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void moduloTest() {
        int actualResult = Calculator.modulo(100, 20);
        int expectedResult = 0;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void BMITest() {
        double actualResult = Calculator.BMICalculator(73,165);
        double expectedResult = 26.813590449954088;
        Assert.assertEquals(actualResult, expectedResult);
    }

}

