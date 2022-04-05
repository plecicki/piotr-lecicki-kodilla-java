package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        System.out.println("Test - pierwszy test jednostkowy:");
        Calculator calculator = new Calculator();
        Integer add1 = calculator.add(10, 14);
        Integer sub1 = calculator.subtract(13, 25);

        if (add1.equals(10 + 14) && sub1.equals(13 - 25)) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

    }
}
