package com.kodilla.testing.collection;

import java.util.*;

public class OddNumbersExterminator {
    public List<Integer> exterminate(List<Integer> numbers) {
        List<Integer> countableNumbers = new ArrayList<>();
        for (Integer num : numbers) {
            if (num % 2 == 0) {
                countableNumbers.add(num);
            }
        }
        return countableNumbers;
    }
}
