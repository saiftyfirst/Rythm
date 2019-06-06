package com.saiftyfirst;

import com.saiftyfirst.models.matrix.Matrix;

public class Utilities {

    public static int maximum(int a, int b) {
        if (a >= b) return a;
        else return b;
    }

    public static int minimum(int a, int b) {
        if (a <= b) return a;
        else return b;
    }

    public static boolean areMulipliable(Matrix[] matrices) {
        for(int i = 0; i < matrices.length - 1; i++) {
            if (!(matrices[i].getDimensions().getY() == matrices[i+1].getDimensions().getX())) {
                return false;
            }
        }
        return true;
    }
}
