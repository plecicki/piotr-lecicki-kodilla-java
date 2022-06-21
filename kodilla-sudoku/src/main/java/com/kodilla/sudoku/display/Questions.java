package com.kodilla.sudoku.display;

import java.util.Scanner;

public class Questions {

    public static boolean sudokuUnsolvable() {
        boolean answered = false;
        while (!answered) {
            System.out.println("Sudoku is unsolvable or is too hard!!!");
            String answer = choice();
            if (answer.equals("1")) {
                return true;
            } else if (answer.equals("2")) {
                return false;
            } else {
                System.out.println("Incorrect option! Try again!");
            }
        }
        return false;
    }

    public static boolean sudokuFinished() {
        boolean answered = false;
        while (!answered) {
            System.out.println("Sudoku is completed!!!");
            String answer = choice();
            if (answer.equals("1")) {
                return true;
            } else if (answer.equals("2")) {
                return false;
            } else {
                System.out.println("Incorrect option! Try again!");
            }
        }
        return false;
    }

    private static String choice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter:");
        System.out.println("1 - To play again");
        System.out.println("2 - To finish");
        return scanner.nextLine();
    }
}
