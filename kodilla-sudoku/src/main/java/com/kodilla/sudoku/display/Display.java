package com.kodilla.sudoku.display;

public class Display {

    private String filledBoard;
    private int[][] charIndex = new int[9][9];

    public Display(String filledBoard) {
        this.filledBoard = filledBoard;
        fillTable();
    }

    private void fillTable() {
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                for (int k=0; k<3; k++) {
                    for (int l=0; l<3; l++) {
                        charIndex[i*3+k][j+3*l] = 88*i+2*j+22*k+7*l+1;
                    }
                }
            }
        }
    }
    
    public void writeNumber(int row, int column, int number) {
        char[] filledBoardChars = filledBoard.toCharArray();
        filledBoardChars[charIndex[row][column]] = Character.forDigit(number,10);
        filledBoard = String.valueOf(filledBoardChars);
    }

    public String toString() {
        return filledBoard;
    };
}
