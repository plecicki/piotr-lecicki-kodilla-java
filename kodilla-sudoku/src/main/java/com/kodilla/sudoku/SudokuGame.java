package com.kodilla.sudoku;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.display.Display;

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

        SudokuBoard sudokuBoard = new SudokuBoard();
        Display display = new Display(sudokuBoard.toString());

        System.out.println("SUDOKU ALGORITHM");
        System.out.println(display);
        System.out.println("Enter values to board: ");
        System.out.println("Format: row, column, number (Order is important)");
        System.out.println("Examples: (3, 4, 5), (3,4,5), (345), (3a4B!5) - min 3 digits");
        System.out.println("After all write \"SUDOKU\"");

        boolean enteredAllNumbers = false;
        String enteredValue = "";

        int row = 0;
        int column = 0;
        int number = 0;

        Scanner choice = new Scanner(System.in);
        while (!enteredAllNumbers) {
            enteredValue = choice.nextLine();
            if (enteredValue.equals("SUDOKU") || enteredValue.equals("sudoku")) {
                enteredAllNumbers = true;
            } else {
                enteredValue = enteredValue.replaceAll("([a-zA-Z\\W\\s+])", "");
                System.out.println(enteredValue);
                int enteredValueLength = enteredValue.length();
                char[] enteredValueChar = enteredValue.toCharArray();

                if (enteredValueLength >= 3) {
                    row = Character.getNumericValue(enteredValueChar[0]);
                    column = Character.getNumericValue(enteredValueChar[1]);
                    number = Character.getNumericValue(enteredValueChar[2]);
                    if (row != 9 && column != 9 && number != 0) {
                        display.writeNumber(row, column, number);
                        System.out.println(display);

                        sudokuBoard.getRows().get(row).getElements().get(column).setNumber(number);
                    } else {
                        System.out.println("Incorrect value/s");
                        System.out.println("Rows: 0-8, Columns: 0-8, Numbers: 1-9");
                    }
                } else {
                    System.out.println("Incorrect format (min. 3 digits");
                    System.out.println("or \"SUDOKU\" to start calculating");
                }

                System.out.println(row + " " + column + " " + number);
            }
        }
        return true; //TODO: SET LOGIC TO FINISH GAME
    }
}
