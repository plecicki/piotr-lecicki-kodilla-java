package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;


import java.util.*;

public class CollectionTestSuite {
    @BeforeEach
    public void before() {
        System.out.println("Test case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test case: end");
    }

    @DisplayName("When list in argument don't have elements" +
    " then method should return empty list")
    @Test
    void testOddNumbersExterminatorEmptyList() {
        //Given
        List<Integer> num = new ArrayList<>();
        OddNumbersExterminator countableColl = new OddNumbersExterminator();
        //When
        List<Integer> numbersCount = countableColl.exterminate(num);
        List<Integer> numResult = new ArrayList<>();
        //Then
        Assertions.assertEquals(numResult, numbersCount);
    }

    @DisplayName("When list in argument have elements" +
            " then method should return only countable numbers in list")
    @Test
    void testOddNumbersExterminatorNormalList() {
        //Given
        Integer numbers[] = new Integer[]
                {4, 123, 124, 5678, 2, 1, 876, 654, 45, 7};
        List<Integer> num = Arrays.asList(numbers);
        OddNumbersExterminator countableColl = new OddNumbersExterminator();
        //When
        List<Integer> numbersCount = countableColl.exterminate(num);
        Integer countable[] = new Integer[]
                {4, 124, 5678, 2, 876, 654};
        List<Integer> numResult = Arrays.asList(countable);
        //Then
        Assertions.assertEquals(numResult, numbersCount);

    }
}
