package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculatorTestSuite {

    @Autowired
    private Calculator calculator;

    @Test
    void testCalculations() {
        //Given
        double addResult;
        double subResult;
        double mulResult;
        double divResult;
        //When
        addResult = calculator.add(5, 5);
        subResult = calculator.sub(10, 4);
        mulResult = calculator.mul(5, 7);
        divResult = calculator.div(15, 10);
        //Then
        Assertions.assertEquals(10, addResult);
        Assertions.assertEquals(6, subResult);
        Assertions.assertEquals(35, mulResult);
        Assertions.assertEquals(1.5, divResult);
    }
}
