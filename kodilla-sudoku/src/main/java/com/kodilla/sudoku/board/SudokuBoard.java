package com.kodilla.sudoku.board;

import com.kodilla.sudoku.SudokuGame;

import java.util.ArrayList;
import java.util.List;

public class SudokuBoard extends Prototype<SudokuBoard> {

    private List<SudokuRow> rows = new ArrayList<>();

    public SudokuBoard() {
        for (int i=0; i<9; i++) {
            rows.add(new SudokuRow());
        }
    }

    public List<SudokuRow> getRows() {
        return rows;
    }

    public SudokuBoard deepCopy() throws CloneNotSupportedException {
        SudokuBoard clonedSudokuBoard = super.clone();
        clonedSudokuBoard.rows = new ArrayList<>();
        for (SudokuRow row : rows) {
            SudokuRow clonedRow = new SudokuRow();
            for(SudokuElement element : row.getElements()) {
                //TODO Debug
                SudokuElement clonedElement = new SudokuElement();
                clonedElement.setNumber(element.getNumber());
                clonedElement.setPossibleNumbers(element.getPossibleNumbers());
                clonedElement.setWasGuessed(element.getWasGuessed());

                clonedRow.getElements().add(clonedElement);
            }
            clonedSudokuBoard.getRows().add(row);
        }
        return clonedSudokuBoard;
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
