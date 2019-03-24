package com.bootcamp.matrix;

import com.bootcamp.day1.NegativeDimensionException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

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
        matrix.setRow(rowNumber, 1,2,3);

        ArrayList<ArrayList<Integer>> expected2DList = new ArrayList<>(2);
        expected2DList.add(new ArrayList<>(2));
        expected2DList.add(new ArrayList<>(2));

        expected2DList.get(0).add(1);
        expected2DList.get(0).add(2);
        expected2DList.get(0).add(3);
        expected2DList.get(1).add(0);
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
        matrix.setRow(rowNumber, 1,2,3);

        rowNumber = PositiveInteger.create(1);
        matrix.setRow(rowNumber, 4,5,6);

        ArrayList<ArrayList<Integer>> expected2DList = new ArrayList<>(2);
        expected2DList.add(new ArrayList<>(2));
        expected2DList.add(new ArrayList<>(2));

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
        matrix.setRow(rowNumber, 1,2,3);

        PositiveInteger row = PositiveInteger.create(0);
        PositiveInteger column = PositiveInteger.create(1);
        assertEquals(2, matrix.getElement(row, column));
    }

}