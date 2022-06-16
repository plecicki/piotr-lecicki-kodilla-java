package com.kodilla.sudoku;

import java.util.Scanner;

public class SudokuGame {

    public static void main(String[] args) {
        boolean gameFinished = false;
        while (!gameFinished) {
            SudokuGame sudokuGame = new SudokuGame();
            gameFinished = sudokuGame.resolveSudoku();
        }
    }

    private boolean resolveSudoku() {
        System.out.println("SUDOKU ALGORITHM");
        System.out.println("Enter values to board: ");
        System.out.println("Format: row, column, number (Order is important)");
        System.out.println("Examples: (3, 4, 5), (3,4,5), (345), (3a4B!5) - min 3 digits");
        System.out.println("After all write \"SUDOKU\"");

        boolean enteredAllNumbers = false;
        String enteredValue = "";
        Scanner choice = new Scanner(System.in);
        while (!enteredAllNumbers) {
            enteredValue = choice.nextLine();
            if (enteredValue.equals("SUDOKU") || enteredValue.equals("sudoku")) {
                //TODO: START CALCULATION
                enteredAllNumbers = true;
            } else {
                enteredValue = enteredValue.replaceAll("([a-zA-Z\\W])", "");
                enteredValue = enteredValue.replaceAll("\\s+","");
                System.out.println(enteredValue);
                int enteredValueLength = enteredValue.length();
                int enteredValueInt = Integer.parseInt(enteredValue);
                char[] enteredValueChar = enteredValue.toCharArray();
                int row = 0;
                int column = 0;
                int number = 0;
                if ((enteredValueInt >= 100 || enteredValueChar[0] == '0' || enteredValueChar[1] == '0') &&
                        (enteredValueLength >= 3)) {
                    row = Character.getNumericValue(enteredValueChar[0]);
                    column = Character.getNumericValue(enteredValueChar[1]);
                    number = Character.getNumericValue(enteredValueChar[2]);
                    if (row != 9 && column != 9 && number != 0) {
                        //TODO: FILL ONE ELEMENT
                    } else {
                        System.out.println("Incorrect value/s 2");
                    }
                } else {
                    System.out.println("Incorrect value/s 1");
                }

                System.out.println(row + " " + column + " " + number);
            }
        }
        return true; //TODO: SET LOGIC TO FINISH GAME
    }
}
