package com.kodilla.sudoku.board;

import java.util.ArrayList;
import java.util.List;

public class SudokuBoard {

    private List<SudokuRow> rows = new ArrayList<>();

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
                "| | | || | | || | | |\n";
    }
}
