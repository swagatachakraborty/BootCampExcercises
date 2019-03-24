package com.bootcamp.matrix;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {
    @Test
    void ShouldCreateZeroMatrixOfGivenRowsAndColumn() {
        Matrix matrix = new Matrix(2, 2);
        ArrayList<ArrayList<Integer>> expected2DList = new ArrayList<>(2);
        expected2DList.add(new ArrayList<>(2));
        expected2DList.add(new ArrayList<>(2));
        expected2DList.get(0).add(0);
        expected2DList.get(0).add(0);
        expected2DList.get(1).add(0);
        expected2DList.get(1).add(0);

        assertEquals(expected2DList, matrix.getMatrix());
    }

}