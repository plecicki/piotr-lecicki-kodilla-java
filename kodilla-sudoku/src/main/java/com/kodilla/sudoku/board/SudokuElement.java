package com.kodilla.sudoku.board;

public class SudokuElement {

    private int number;
    private int[] possibleNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    private boolean[] wasGuessed = {false, false, false, false, false, false, false, false, false};

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

    public void setPossibleNumbers(int impossibleNumber) {
        this.possibleNumbers[impossibleNumber - 1] = EMPTY;
    }

    public boolean[] getWasGuessed() {
        return wasGuessed;
    }

    public void setWasGuessed(boolean[] wasGuessed) {
        this.wasGuessed = wasGuessed;
    }
}
