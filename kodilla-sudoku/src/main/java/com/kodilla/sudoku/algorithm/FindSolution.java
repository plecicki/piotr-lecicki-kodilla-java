package com.kodilla.sudoku.algorithm;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.display.Display;

public class FindSolution {

    private SudokuBoard sudokuBoard;
    private SudokuBoard deepCopyBoard;
    private Display display;
    private boolean unsolvable = false;
    private boolean madeCopy = false;

    private boolean wasSomethingDoneDuringThisIteration;

    public boolean start(SudokuBoard sudokuBoard, Display display) {
        this.sudokuBoard = sudokuBoard;
        this.display = display;
        boolean fullBoardIsFilled = singleGameLoop();
        return fullBoardIsFilled;
    }

    private boolean singleGameLoop() {
        boolean solved = false;
        while (!solved && !unsolvable) {
            wasSomethingDoneDuringThisIteration = false;
            solved = !elementsIterate();
            //TODO solved = elementsIterate();
        }
        System.out.println(display);
        return solved;
    }

    private boolean elementsIterate() {
        boolean isEveryElementFilled = true;
        int elementNumber;
        for (int rowLoop = 0; rowLoop < 9; rowLoop++) {
            for (int columnLoop = 0; columnLoop < 9; columnLoop++) {
                if (isEmpty(rowLoop, columnLoop)) {
                    isEveryElementFilled = false;
                    //Check rows and columns:
                    int othersNumber = -1;
                    for (int i=0; i<9; i++) {
                        checkRows(rowLoop, columnLoop, othersNumber, i);
                        checkColumns(rowLoop, columnLoop, othersNumber, i);
                    }
                    //Check block:
                    int blockIndex = checkBlockIndex(rowLoop, columnLoop);
                    checkBlock(rowLoop, columnLoop, blockIndex);
                    //todo Check tables others [To check!!!] impossible numbers to iterate and calculate
                    checkOthersTables(rowLoop, columnLoop, blockIndex);

                    //Is table has only one element:
                    if (isTableHavingOnlyOneItem(rowLoop, columnLoop)) {
                        //Check this number:
                        elementNumber = findAvailableNumber(rowLoop, columnLoop);
                        //Write number to object
                        sudokuBoard.getRows().get(rowLoop).getElements().get(columnLoop).setNumber(elementNumber);
                        display.writeNumber(rowLoop, columnLoop, elementNumber);
                        wasSomethingDoneDuringThisIteration = true;
                    }
                }
            }
        }
        if (!wasSomethingDoneDuringThisIteration) {
            //TODO Guesting
            if (!madeCopy) {
                makeBoardCopy(deepCopyBoard, sudokuBoard);
            } else {
                //TODO Guess
            }

        }
        //TODO Check collisions
        return isEveryElementFilled;
    }

    private void makeBoardCopy(SudokuBoard clone, SudokuBoard cloned) {
        try {
            clone = cloned.deepCopy();
            madeCopy = true;
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
    }

    private boolean isEmpty(int row, int column) {
        int number = sudokuBoard.getRows().get(row).getElements().get(column).getNumber();
        return (number == -1);
    }

    private boolean isTableHavingOnlyOneItem(int row, int column) {
        int numberCounter = 0;
        for (int i=0; i<9; i++) {
            if (sudokuBoard.getRows().get(row).getElements().get(column).getPossibleNumbers()[i] == i+1) {
                numberCounter++;
            }
        }
        if (numberCounter == 1) {
            return true;
        }
        return false;
    }

    private int findAvailableNumber(int row, int column) {
        for (int i=0; i<9; i++) {
            if (sudokuBoard.getRows().get(row).getElements().get(column).getPossibleNumbers()[i] == i+1) {
                return i+1;
            }
        }
        return -1;
    }

    private void checkRows(int row, int column, int othersNumber, int i) {
        othersNumber = sudokuBoard.getRows().get(i).getElements().get(column).getNumber();
        if (othersNumber != -1 && i != row) {
            sudokuBoard.getRows().get(row).getElements().get(column).getPossibleNumbers()[othersNumber - 1] = -1;
            wasSomethingDoneDuringThisIteration = true;
        }
    }

    private void checkColumns(int row, int column, int othersNumber, int i) {
        othersNumber = sudokuBoard.getRows().get(row).getElements().get(i).getNumber();
        if (othersNumber != -1 && i != column) {
            sudokuBoard.getRows().get(row).getElements().get(column).getPossibleNumbers()[othersNumber - 1] = -1;
            wasSomethingDoneDuringThisIteration = true;
        }
    }

    private int checkBlockIndex(int row, int column) {
        int blockIndex = -1;
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if ((row >= i*3 && row < (i+1)*3) &&
                        (column >= j*3 && column < (j+1)*3)) {
                    blockIndex = 3*i+j;
                }
            }
        }
        return blockIndex;
    }

    private void checkBlock(int row, int column, int blockIndex) {
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                boolean sameBlock = (checkBlockIndex(i, j) == blockIndex);
                if (sameBlock && !(i == row && j == column)) {
                    int othersNumber = sudokuBoard.getRows().get(i).getElements().get(j).getNumber();
                    if (othersNumber != -1) {
                        sudokuBoard.getRows().get(row).getElements().get(column).getPossibleNumbers()[othersNumber - 1] = -1;
                        wasSomethingDoneDuringThisIteration = true;
                    }
                }
            }
        }
    }

    private void checkOthersTables(int row, int column, int blockIndex) {
        int[] impossibleNumbers = {-1, -1, -1, -1, -1, -1, -1, -1, -1};
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                //Block
                boolean sameBlock = checkBlockIndex(i, j) == blockIndex;
                if ((sameBlock && !(i == row && j == column)) ||
                        (column == j && row != i) ||
                        (column != j && row == i)) {
                    int[] othersTable = sudokuBoard.getRows().get(i).getElements().get(j).getPossibleNumbers();
                    for (int k=0; k<9; k++) {
                        if (othersTable[k] != -1) {
                            impossibleNumbers[k] = k+1;
                        }
                    }
                }
            }
        }
        int loopCounter = 0;
        for (int l=0; l<9; l++) {
            if (impossibleNumbers[l] == -1) {
                loopCounter++;
            }
        }
        if (loopCounter == 1) {
            for (int k=0; k<9; k++) {
                if (impossibleNumbers[k] != -1) {
                    sudokuBoard.getRows().get(row).getElements().get(column).getPossibleNumbers()[k] = -1;
                    wasSomethingDoneDuringThisIteration = true;
                }
            }
        }
    }

    public boolean isUnsolvable() {
        return unsolvable;
    }
}
