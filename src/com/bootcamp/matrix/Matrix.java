package com.bootcamp.matrix;

import java.util.ArrayList;

class Matrix {
    private final int row;
    private final int column;
    private ArrayList<ArrayList<Integer>> matrix;

    Matrix(int row, int column) {
        this.row = row;
        this.column = column;
        this.matrix = new ArrayList<>(row);
        this.create();
    }

    private void create() {
        for (int i = 0; i < this.row; i++) {
            this.matrix.add(new ArrayList<>(this.column));
            for (int i1 = 0; i1 < this.column; i1++) {
                this.matrix.get(i).add(0);
            }
        }
    }

    ArrayList<ArrayList<Integer>> getMatrix() {
        return this.matrix;
    }
}
