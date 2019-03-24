package com.bootcamp.matrix;

import com.bootcamp.day1.NegativeDimensionException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MatrixTest {
    @Test
    void ShouldCreateZeroMatrixOfGivenRowsAndColumnWhichAreSame() throws NegativeDimensionException {
        PositiveInteger rowSize = PositiveInteger.create(2);
        PositiveInteger columnSize = PositiveInteger.create(2);
        Matrix matrix = new Matrix(rowSize, columnSize);

        ArrayList<ArrayList<Integer>> expected2DList = new ArrayList<>(2);
        expected2DList.add(new ArrayList<>(2));
        expected2DList.add(new ArrayList<>(2));

        expected2DList.get(0).add(0);
        expected2DList.get(0).add(0);
        expected2DList.get(1).add(0);
        expected2DList.get(1).add(0);

        assertEquals(expected2DList, matrix.getMatrix());
    }

    @Test
    void ShouldCreateZeroMatrixOfGivenRowsAndColumnWhichAreDifferent() throws NegativeDimensionException {
        PositiveInteger rowSize = PositiveInteger.create(2);
        PositiveInteger columnSize = PositiveInteger.create(3);
        Matrix matrix = new Matrix(rowSize, columnSize);

        ArrayList<ArrayList<Integer>> expected2DList = new ArrayList<>(2);
        expected2DList.add(new ArrayList<>(2));
        expected2DList.add(new ArrayList<>(2));

        expected2DList.get(0).add(0);
        expected2DList.get(0).add(0);
        expected2DList.get(0).add(0);
        expected2DList.get(1).add(0);
        expected2DList.get(1).add(0);
        expected2DList.get(1).add(0);

        assertEquals(expected2DList, matrix.getMatrix());
    }

    @Test
    void ShouldSetTheRowAccordingToTheGivenElements() throws NegativeDimensionException {
        PositiveInteger rowSize = PositiveInteger.create(2);
        PositiveInteger columnSize = PositiveInteger.create(3);
        Matrix matrix = new Matrix(rowSize, columnSize);

        PositiveInteger rowNumber = PositiveInteger.create(0);
        matrix.setRow(rowNumber, 1, 2, 3);

        ArrayList<ArrayList<Integer>> expected2DList = new ArrayList<>(2);
        expected2DList.add(new ArrayList<>(3));
        expected2DList.add(new ArrayList<>(3));

        expected2DList.get(0).add(1);
        expected2DList.get(0).add(2);
        expected2DList.get(0).add(3);
        expected2DList.get(1).add(0);
        expected2DList.get(1).add(0);
        expected2DList.get(1).add(0);

        assertEquals(expected2DList, matrix.getMatrix());
    }

    @Test
    void ShouldSetTheElementToTheGivenRowAndColumn() throws NegativeDimensionException {
        PositiveInteger rowSize = PositiveInteger.create(2);
        PositiveInteger columnSize = PositiveInteger.create(2);
        Matrix matrix = new Matrix(rowSize, columnSize);

        PositiveInteger rowNumber = PositiveInteger.create(0);
        PositiveInteger columnNumber = PositiveInteger.create(0);

        matrix.set(rowNumber, columnNumber, 1);

        ArrayList<ArrayList<Integer>> expected2DList = new ArrayList<>(2);
        expected2DList.add(new ArrayList<>(2));
        expected2DList.add(new ArrayList<>(2));

        expected2DList.get(0).add(1);
        expected2DList.get(0).add(0);
        expected2DList.get(1).add(0);
        expected2DList.get(1).add(0);

        assertEquals(expected2DList, matrix.getMatrix());

    }

    @Test
    void ShouldSetTheRowAccordingToTheGivenElements2() throws NegativeDimensionException {
        PositiveInteger rowSize = PositiveInteger.create(2);
        PositiveInteger columnSize = PositiveInteger.create(3);
        Matrix matrix = new Matrix(rowSize, columnSize);

        PositiveInteger rowNumber = PositiveInteger.create(0);
        matrix.setRow(rowNumber, 1, 2, 3);

        rowNumber = PositiveInteger.create(1);
        matrix.setRow(rowNumber, 4, 5, 6);

        ArrayList<ArrayList<Integer>> expected2DList = new ArrayList<>(2);
        expected2DList.add(new ArrayList<>(3));
        expected2DList.add(new ArrayList<>(3));

        expected2DList.get(0).add(1);
        expected2DList.get(0).add(2);
        expected2DList.get(0).add(3);
        expected2DList.get(1).add(4);
        expected2DList.get(1).add(5);
        expected2DList.get(1).add(6);

        assertEquals(expected2DList, matrix.getMatrix());
    }

    @Test
    void ShouldReturnTheElementOfGivenRowAndColumn() throws NegativeDimensionException {
        PositiveInteger rowSize = PositiveInteger.create(2);
        PositiveInteger columnSize = PositiveInteger.create(3);
        Matrix matrix = new Matrix(rowSize, columnSize);

        PositiveInteger rowNumber = PositiveInteger.create(0);
        matrix.setRow(rowNumber, 1, 2, 3);

        assertEquals(2, matrix.getElement(0, 1));
    }


    @Test
    void ShouldThrowExceptionForAdditionOfTwoDifferentSizeMatrices() throws Exception {
        PositiveInteger rowSize = PositiveInteger.create(2);
        PositiveInteger columnSize = PositiveInteger.create(3);
        Matrix matrix1 = new Matrix(rowSize, columnSize);

        rowSize = PositiveInteger.create(3);
        Matrix matrix2 = new Matrix(rowSize, columnSize);

        assertThrows(Exception.class, () -> matrix1.add(matrix2));
    }

    @Test
    void addShouldReturnTheAdditionOfTheGivenMatrices() throws Exception {
        PositiveInteger rowSize = PositiveInteger.create(2);
        PositiveInteger columnSize = PositiveInteger.create(3);

        Matrix matrix1 = new Matrix(rowSize, columnSize);

        PositiveInteger rowNumber = PositiveInteger.create(0);
        matrix1.setRow(rowNumber, 1, 2, 3);
        rowNumber = PositiveInteger.create(1);
        matrix1.setRow(rowNumber, 4, 5, 6);

        Matrix matrix2 = new Matrix(rowSize, columnSize);

        rowNumber = PositiveInteger.create(0);
        matrix2.setRow(rowNumber, 4, 5, 6);
        rowNumber = PositiveInteger.create(1);
        matrix2.setRow(rowNumber, 1, 2, 3);

        Matrix addition = new Matrix(rowSize, columnSize);

        rowNumber = PositiveInteger.create(0);
        addition.setRow(rowNumber, 5, 7, 9);
        rowNumber = PositiveInteger.create(1);
        addition.setRow(rowNumber, 5, 7, 9);

        assertEquals(addition, matrix1.add(matrix2));
    }

    @Test
    void transposeShouldReturnTheTransposeOfTheMatrix() throws NegativeDimensionException {
        PositiveInteger rowSize = PositiveInteger.create(2);
        PositiveInteger columnSize = PositiveInteger.create(2);

        Matrix matrix = new Matrix(rowSize, columnSize);

        PositiveInteger rowNumber = PositiveInteger.create(0);
        matrix.setRow(rowNumber, 1, 2);
        rowNumber = PositiveInteger.create(1);
        matrix.setRow(rowNumber, 4, 5);

        Matrix transposeMatrix = new Matrix(columnSize, rowSize);

        rowNumber = PositiveInteger.create(0);
        transposeMatrix.setRow(rowNumber, 1, 4);
        rowNumber = PositiveInteger.create(1);
        transposeMatrix.setRow(rowNumber, 2, 5);

        assertEquals(transposeMatrix.getMatrix(), matrix.transpose().getMatrix());
    }
}