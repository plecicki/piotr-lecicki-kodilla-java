package com.kodilla.sudoku.board;

public class SudokuElement {

    private int number;
    private int[] possibleNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static int EMPTY = -1;

    public SudokuElement() {
        this.number = EMPTY;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int[] getPossibleNumbers() {
        return possibleNumbers;
    }

    public void setPossibleNumbers(int[] possibleNumbers) {
        this.possibleNumbers = possibleNumbers;
    }
}
