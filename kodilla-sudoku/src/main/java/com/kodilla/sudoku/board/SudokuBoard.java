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
