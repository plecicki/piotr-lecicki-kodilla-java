package com.kodilla.sudoku.algorithm;

import com.kodilla.sudoku.board.SudokuBoard;

public class FindSolution {

    private SudokuBoard sudokuBoard;
    private boolean madeOperationInLastLoop = false;

    public void start(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
        algorithmLoop();
    }

    private void algorithmLoop() {
        boolean solved = false;
        while (solved) {
            solved = !elementsIterate();
        }
    }

    private boolean elementsIterate() {
        boolean isEveryElementFilled = true;
        for (int rowLoop = 0; rowLoop < 9; rowLoop++) {
            for (int columnLoop = 0; columnLoop < 9; columnLoop++) {
                if (isEmpty(rowLoop, columnLoop)) {
                    isEveryElementFilled = false;
                    //Is table having one element:
                    //Check rows
                    //Check columns
                    //Check block
                    //Check tables others
                }
            }
        }
        return isEveryElementFilled;
    }

    private boolean isEmpty(int row, int column) {
        int number = sudokuBoard.getRows().get(row).getElements().get(column).getNumber();
        if (number == -1) {
            return true;
        }
        return false;
    }
}
