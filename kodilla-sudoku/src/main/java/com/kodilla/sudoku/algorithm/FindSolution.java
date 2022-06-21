package com.kodilla.sudoku.algorithm;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.display.Display;

public class FindSolution {

    private SudokuBoard sudokuBoard;
    private SudokuBoard deepCopyBoard;
    private Display display;
    private Display deepCopyDisplay;
    private boolean unsolvable = false;
    private boolean madeCopy = false;
    private boolean[][][] wasGuessed = new boolean[9][9][9];

    private boolean wasSomethingDoneDuringThisIteration;

    public boolean start(SudokuBoard sudokuBoard, Display display) {
        this.sudokuBoard = sudokuBoard;
        this.display = display;
        fillGuessTable();
        boolean fullBoardIsFilled = singleGameLoop();
        return fullBoardIsFilled;
    }

    private void fillGuessTable() {
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                for (int k=0; k<9; k++) {
                    wasGuessed[i][j][k] = false;
                }
            }
        }
    }

    private boolean singleGameLoop() {
        boolean solved = false;
        while (!solved && !unsolvable) {
            wasSomethingDoneDuringThisIteration = false;
            solved = elementsIterate();
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
                    int blockIndex = checkBlockIndex(rowLoop, columnLoop);

                    checkRows(rowLoop, columnLoop);
                    checkColumns(rowLoop, columnLoop);
                    checkBlock(rowLoop, columnLoop, blockIndex);
                    checkOthersTables(rowLoop, columnLoop, blockIndex);

                    if (isTableHavingOnlyOneItem(rowLoop, columnLoop)) {
                        elementNumber = findAvailableNumber(rowLoop, columnLoop);
                        sudokuBoard.getRows().get(rowLoop).getElements().get(columnLoop).setNumber(elementNumber);
                        display.writeNumber(rowLoop, columnLoop, elementNumber);
                        wasSomethingDoneDuringThisIteration = true;
                    }

                    if (isCollision(rowLoop, columnLoop, blockIndex)) {
                        if (madeCopy) {
                            try {
                                sudokuBoard = deepCopyBoard.deepCopy();
                                display = deepCopyDisplay.deepCopy();
                            } catch (CloneNotSupportedException e) {
                                System.out.println(e);
                            }
                            madeCopy = false;
                        } else {
                            unsolvable = true;
                        }
                    }
                } else {
                    for (int i=0; i<9; i++) {
                        if (sudokuBoard.getRows().get(rowLoop).getElements().get(columnLoop).getNumber() != i + 1) {
                            sudokuBoard.getRows().get(rowLoop).getElements().get(columnLoop).getPossibleNumbers()[i] = -1;
                        } else {
                            sudokuBoard.getRows().get(rowLoop).getElements().get(columnLoop).getPossibleNumbers()[i] = i+1;
                        }
                    }
                }
            }
        }
        if (!wasSomethingDoneDuringThisIteration) {
            if (!madeCopy) {
                try {
                    deepCopyBoard = sudokuBoard.deepCopy();
                    deepCopyDisplay = display.deepCopy();
                } catch (CloneNotSupportedException e) {
                    System.out.println(e);
                }
                madeCopy = true;
                guess();
            } else {
                guessAgain();
            }

        }
        return isEveryElementFilled;
    }

    private boolean isCollision(int row, int column, int blockIndex) {
        int number1;
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                boolean sameBlock = checkBlockIndex(i, j) == blockIndex;
                if ((sameBlock && !(i == row && j == column)) ||
                        (column == j && row != i) ||
                        (column != j && row == i)) {
                    number1 = sudokuBoard.getRows().get(row).getElements().get(column).getNumber();
                    if (isTableHavingOnlyOneItem(i, j)) {
                        int availableNumber = findAvailableNumber(i, j);
                        if (availableNumber == number1 && number1 != -1) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private void guess() {
        boolean isGuessed = false;
        for (int rowGuess = 0; rowGuess < 9; rowGuess++) {
            for (int columnGuess = 0; columnGuess < 9; columnGuess++) {
                for (int i=0; i<9; i++) {
                    if (isEmpty(rowGuess, columnGuess) && !isGuessed &&
                            sudokuBoard.getRows().get(rowGuess).getElements().get(columnGuess).getPossibleNumbers()[i] == i+1 &&
                            wasGuessed[rowGuess][columnGuess][i] == false) {
                        for (int j=0; j<9; j++) {
                            if (j == i) {
                                sudokuBoard.getRows().get(rowGuess).getElements().get(columnGuess).getPossibleNumbers()[j] = j+1;
                            } else {
                                sudokuBoard.getRows().get(rowGuess).getElements().get(columnGuess).getPossibleNumbers()[j] = -1;
                            }
                        }
                        sudokuBoard.getRows().get(rowGuess).getElements().get(columnGuess).setNumber(i+1);
                        wasGuessed[rowGuess][columnGuess][i] = true;
                        display.writeNumber(rowGuess, columnGuess, i+1);
                        isGuessed = true;
                    }
                }
            }
        }
        if (!isGuessed) {
            unsolvable = true;
        }
    }

    private void guessAgain() {
        boolean isGuessed = false;
        for (int rowGuess = 0; rowGuess < 9; rowGuess++) {
            for (int columnGuess = 0; columnGuess < 9; columnGuess++) {
                for (int i=0; i<9; i++) {
                    if (isEmpty(rowGuess, columnGuess) && !isGuessed &&
                            sudokuBoard.getRows().get(rowGuess).getElements().get(columnGuess).getPossibleNumbers()[i] == i+1) {
                        for (int j=0; j<9; j++) {
                            if (j == i) {
                                sudokuBoard.getRows().get(rowGuess).getElements().get(columnGuess).getPossibleNumbers()[j] = j+1;
                            } else {
                                sudokuBoard.getRows().get(rowGuess).getElements().get(columnGuess).getPossibleNumbers()[j] = -1;
                            }
                        }
                        sudokuBoard.getRows().get(rowGuess).getElements().get(columnGuess).setNumber(i+1);
                        display.writeNumber(rowGuess, columnGuess, i+1);
                        isGuessed = true;
                    }
                }
            }
        }
        if (!isGuessed) {
            unsolvable = true;
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

    private void checkRows(int row, int column) {
        int othersNumber;
        for (int i=0; i<9; i++) {
            othersNumber = sudokuBoard.getRows().get(i).getElements().get(column).getNumber();
            if (othersNumber != -1 && i != row) {
                if (sudokuBoard.getRows().get(row).getElements().get(column).getPossibleNumbers()[othersNumber - 1] != -1) {
                    sudokuBoard.getRows().get(row).getElements().get(column).getPossibleNumbers()[othersNumber - 1] = -1;
                    wasSomethingDoneDuringThisIteration = true;
                }
            }
        }
    }

    private void checkColumns(int row, int column) {
        int othersNumber;
        for (int i=0; i<9; i++) {
            othersNumber = sudokuBoard.getRows().get(row).getElements().get(i).getNumber();
            if (othersNumber != -1 && i != column) {
                if (sudokuBoard.getRows().get(row).getElements().get(column).getPossibleNumbers()[othersNumber - 1] != -1) {
                    sudokuBoard.getRows().get(row).getElements().get(column).getPossibleNumbers()[othersNumber - 1] = -1;
                    wasSomethingDoneDuringThisIteration = true;
                }
            }
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
                        if (sudokuBoard.getRows().get(row).getElements().get(column).getPossibleNumbers()[othersNumber - 1] != -1) {
                            sudokuBoard.getRows().get(row).getElements().get(column).getPossibleNumbers()[othersNumber - 1] = -1;
                            wasSomethingDoneDuringThisIteration = true;
                        }
                    }
                }
            }
        }
    }

    private void checkOthersTables(int row, int column, int blockIndex) {
        int[] impossibleNumbers = {-1, -1, -1, -1, -1, -1, -1, -1, -1};
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
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
                    if (sudokuBoard.getRows().get(row).getElements().get(column).getPossibleNumbers()[k] != -1) {
                        sudokuBoard.getRows().get(row).getElements().get(column).getPossibleNumbers()[k] = -1;
                        wasSomethingDoneDuringThisIteration = true;
                    }
                }
            }
        }
    }

    public boolean isUnsolvable() {
        return unsolvable;
    }
}
