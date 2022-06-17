package com.kodilla.sudoku.board;

import java.util.ArrayList;
import java.util.List;

public class SudokuBoard {

    private List<SudokuRow> rows = new ArrayList<>();

    public SudokuBoard() {
        for (int i=0; i<9; i++) {
            rows.add(new SudokuRow());
        }
    }

    public List<SudokuRow> getRows() {
        return rows;
    }

    public void writeNumber(int rowIndex, int elementIndex, int number) {
        rows.get(rowIndex).getElements().get(elementIndex).setNumber(number);
        rows.get(rowIndex).getElements().get(elementIndex).setPossibleNumbers(number);
    }

    @Override
    public String toString() {
        return
                "| | | || | | || | | |\n" +
                "| | | || | | || | | |\n" +
                "| | | || | | || | | |\n" +
                "---------------------\n" +
                "| | | || | | || | | |\n" +
                "| | | || | | || | | |\n" +
                "| | | || | | || | | |\n" +
                "---------------------\n" +
                "| | | || | | || | | |\n" +
                "| | | || | | || | | |\n" +
                "| | | || | | || | | |";
    }
}
