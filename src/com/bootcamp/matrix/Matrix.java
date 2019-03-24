package com.bootcamp.matrix;

import java.util.ArrayList;

import static java.util.Arrays.asList;

class Matrix {
    private final PositiveInteger row;
    private final PositiveInteger column;
    private ArrayList<ArrayList<Integer>> matrix;

    Matrix(PositiveInteger row, PositiveInteger column) {
        this.row = row;
        this.column = column;
        this.matrix = new ArrayList<>(row.getValue());
        this.create();
    }

    private void create() {
        for (int i = 0; i < this.row.getValue(); i++) {
            this.matrix.add(new ArrayList<>(this.column.getValue()));
            for (int i1 = 0; i1 < this.column.getValue(); i1++) {
                this.matrix.get(i).add(0);
            }
        }
    }

    void setRow(PositiveInteger rowNumber,Integer ...values) {
        ArrayList<Integer> row = new ArrayList<>(asList(values));
        matrix.set(rowNumber.getValue(), row);
    }

    ArrayList<ArrayList<Integer>> getMatrix() {
        return this.matrix;
    }

    Integer getElement(PositiveInteger row, PositiveInteger column) {
        return this.matrix.get(row.getValue()).get(column.getValue());
    }
}
