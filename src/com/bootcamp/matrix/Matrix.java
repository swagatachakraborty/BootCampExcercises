package com.bootcamp.matrix;

import java.util.ArrayList;
import java.util.Objects;

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

    PositiveInteger getRow() {
        return row;
    }

    PositiveInteger getColumn() {
        return column;
    }

    private void create() {
        for (int i = 0; i < this.row.getValue(); i++) {
            this.matrix.add(new ArrayList<>(this.column.getValue()));
            for (int i1 = 0; i1 < this.column.getValue(); i1++) {
                this.matrix.get(i).add(0);
            }
        }
    }

    void setRow(PositiveInteger rowNumber, Integer... values) {
        ArrayList<Integer> row = new ArrayList<>(asList(values));
        matrix.set(rowNumber.getValue(), row);
    }

    void set(PositiveInteger rowNumber, PositiveInteger columnNumber, Integer element) {
        this.matrix.get(rowNumber.getValue()).set(columnNumber.getValue(), element);
    }

    ArrayList<ArrayList<Integer>> getMatrix() {
        return this.matrix;
    }

    Integer getElement(Integer row, Integer column) {
        return this.matrix.get(row).get(column);
    }

    Matrix add(Matrix other) throws Exception {
        if (!this.addableTo(other)) {
            throw new Exception("Can not add Different size matrix.");
        }

        Matrix addition = new Matrix(this.row, this.column);

        for (int row = 0; row < this.row.getValue(); row++) {
            for (int column = 0; column < this.column.getValue(); column++) {
                Integer sum = this.matrix.get(row).get(column) + other.getMatrix().get(row).get(column);
                addition.getMatrix().get(row).set(column, sum);
            }
        }

        return addition;
    }

    private boolean addableTo(Matrix other) {
        return this.row.equals(other.getRow()) && this.column.equals(other.getColumn());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix1 = (Matrix) o;
        return Objects.equals(row, matrix1.row) &&
                Objects.equals(column, matrix1.column) &&
                Objects.equals(matrix, matrix1.matrix);
    }
}
