package com.kodilla.sudoku.board;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {

    private List<SudokuElement> elements = new ArrayList<>();

    public SudokuRow() {
        for (int i=0; i<9; i++) {
            elements.add(new SudokuElement());
        }
    }

    public List<SudokuElement> getElements() {
        return elements;
    }

    public void setElements(List<SudokuElement> elements) {
        this.elements = elements;
    }
}
