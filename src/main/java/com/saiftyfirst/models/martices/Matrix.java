package com.saiftyfirst.models.martices;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Matrix {

    private Dimensions dimensions;
    private int[][] values;

    public Matrix(final Dimensions dimensions) {
        this.dimensions = dimensions;
        this.values = new int[dimensions.getX()][dimensions.getY()];
    }

    public Matrix(final int[][] values) {
        this.dimensions = new Dimensions(values.length, values[0].length);
        this.values = values;
    }

    public void addPoint(final int x, final int y, final int value) {
        this.values[x-1][y-1] = value;
    }

    public int getPoint(final int x, final int y) {
        return this.values[x-1][y-1];
    }

    public Matrix slice(final int xSlice, final int ySlice) {
        Matrix slicedMatrix = new Matrix(new Dimensions(this.dimensions.x - 1, this.dimensions.y - 1));
        int currX = 1, currY;
        for (int i = 1; i <= this.dimensions.x; i++) {
            if (i != xSlice) {
                currY = 1;
                for (int j = 1; j <= this.dimensions.y; j++) {
                    if (j != ySlice) {
                        slicedMatrix.addPoint(currX, currY++, this.values[i-1][j-1]) ;
                    }
                }
                currX++;
            }
        }
        return slicedMatrix;
    }

    public int determinant() {
        assert this.dimensions.getX() >= 2;
        assert this.dimensions.getX() == dimensions.getY();

        int ret = 0;
        Matrix auxMatrix;

        if (dimensions.getX() == 2) {
            ret = this.getPoint(1,1) * this.getPoint(2,2) -
                this.getPoint(1,2) * this.getPoint(2, 1);
        } else {
            for (int i = 0; i < dimensions.getX(); i++) {
                auxMatrix = this.slice(1, i + 1);
                ret += (int) Math.pow(-1, (i+2)) * this.getPoint(1, i + 1) * auxMatrix.determinant();
            }
        }
        return ret;
    }

    @Data
    @AllArgsConstructor
    public static class Dimensions {
        private int x;
        private int y;
    }
}
