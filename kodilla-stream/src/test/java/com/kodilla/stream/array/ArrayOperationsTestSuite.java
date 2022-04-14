package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOperationsTestSuite {
    @Test
    void testGetAverage() {
        //Given
        int[] intValues = {4, 15, 67, 12, 14, 77, 1000};

        //When
        double result = ArrayOperations.getAverage(intValues);

        //Then
        assertEquals(169.857143, result, 0.000001);
    }
}
