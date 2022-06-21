package com.kodilla.sudoku;

import com.kodilla.sudoku.algorithm.FindSolution;
import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.display.Display;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SudokuTestSuite {

    private SudokuBoard sudokuBoard = new SudokuBoard();
    private Display display = new Display(sudokuBoard.toString());

    @Test
    void check5Row() {
        //Given
        fillBoardNRowWithoutLastElement(5);
        FindSolution findSolution = new FindSolution();

        //When
        findSolution.start(sudokuBoard, display);

        //Then
        int lastNumber = sudokuBoard.getRows().get(5).getElements().get(8).getNumber();
        Assertions.assertEquals(9, lastNumber);
    }

    @Test
    void check0Block() {
        //Given
        SudokuBoard sudokuBoard = new SudokuBoard();
        Display display = new Display(sudokuBoard.toString());
        fillBoard0BlockWithoutLastElement(sudokuBoard, display);
        FindSolution findSolution = new FindSolution();

        //When
        findSolution.start(sudokuBoard, display);
        System.out.println(sudokuBoard.getRows().get(2).getElements().get(0).getNumber());
        System.out.println(sudokuBoard.getRows().get(2).getElements().get(1).getNumber());


        //Then
        int lastNumber = sudokuBoard.getRows().get(2).getElements().get(2).getNumber();
        Assertions.assertEquals(9, lastNumber);
    }

//    @Test
//    void checkBlockIndexCheck() {
//        //Given
//        FindSolution findSolution = new FindSolution();
//        //When & Then
//        Assertions.assertEquals(0, findSolution.checkBlockIndex(0,0));
//        Assertions.assertEquals(1, findSolution.checkBlockIndex(1,4));
//        Assertions.assertEquals(2, findSolution.checkBlockIndex(1,8));
//        Assertions.assertEquals(3, findSolution.checkBlockIndex(5,1));
//        Assertions.assertEquals(4, findSolution.checkBlockIndex(4,3));
//        Assertions.assertEquals(5, findSolution.checkBlockIndex(3,7));
//        Assertions.assertEquals(6, findSolution.checkBlockIndex(8,2));
//        Assertions.assertEquals(7, findSolution.checkBlockIndex(7,5));
//        Assertions.assertEquals(8, findSolution.checkBlockIndex(6,6));
//    }

    private void fillBoardNRowWithoutLastElement(int n) {
        for (int i=0; i<8; i++) {
            sudokuBoard.getRows().get(n).getElements().get(i).setNumber(i+1);
            display.writeNumber(n, i, i+1);
            for (int j=0; j<9; j++) {
                if (j != i) {
                    sudokuBoard.getRows().get(n).getElements().get(i).getPossibleNumbers()[j] = -1;
                }
            }
        }
    }

    private void fillBoard0BlockWithoutLastElement(SudokuBoard sudokuBoard, Display display) {
        sudokuBoard.getRows().get(0).getElements().get(0).setNumber(1);
        display.writeNumber(0, 0, 1);
        for (int j=0; j<9; j++) {
            if (j != 0) {
                sudokuBoard.getRows().get(0).getElements().get(0).getPossibleNumbers()[j] = -1;
            }
        }

        sudokuBoard.getRows().get(0).getElements().get(1).setNumber(2);
        display.writeNumber(0, 1, 2);
        for (int j=0; j<9; j++) {
            if (j != 1) {
                sudokuBoard.getRows().get(0).getElements().get(1).getPossibleNumbers()[j] = -1;
            }
        }

        sudokuBoard.getRows().get(0).getElements().get(2).setNumber(3);
        display.writeNumber(0, 2, 3);
        for (int j=0; j<9; j++) {
            if (j != 2) {
                sudokuBoard.getRows().get(0).getElements().get(2).getPossibleNumbers()[j] = -1;
            }
        }

        sudokuBoard.getRows().get(1).getElements().get(0).setNumber(4);
        display.writeNumber(1, 0, 4);
        for (int j=0; j<9; j++) {
            if (j != 3) {
                sudokuBoard.getRows().get(1).getElements().get(0).getPossibleNumbers()[j] = -1;
            }
        }

        sudokuBoard.getRows().get(1).getElements().get(1).setNumber(5);
        display.writeNumber(1, 1, 5);
        for (int j=0; j<9; j++) {
            if (j != 4) {
                sudokuBoard.getRows().get(1).getElements().get(1).getPossibleNumbers()[j] = -1;
            }
        }

        sudokuBoard.getRows().get(1).getElements().get(2).setNumber(6);
        display.writeNumber(1, 2, 6);
        for (int j=0; j<9; j++) {
            if (j != 5) {
                sudokuBoard.getRows().get(1).getElements().get(2).getPossibleNumbers()[j] = -1;
            }
        }

        sudokuBoard.getRows().get(2).getElements().get(1).setNumber(7);
        display.writeNumber(2, 0, 7);
        for (int j=0; j<9; j++) {
            if (j != 6) {
                sudokuBoard.getRows().get(2).getElements().get(0).getPossibleNumbers()[j] = -1;
            }
        }

        sudokuBoard.getRows().get(2).getElements().get(2).setNumber(8);
        display.writeNumber(2, 1, 8);
        for (int j=0; j<9; j++) {
            if (j != 7) {
                sudokuBoard.getRows().get(2).getElements().get(1).getPossibleNumbers()[j] = -1;
            }
        }

        //System.out.println(display);
    }
}
