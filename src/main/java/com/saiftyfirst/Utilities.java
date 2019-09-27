package com.saiftyfirst;

import com.saiftyfirst.models.martices.Matrix;

class Utilities {

    static boolean areMulipliable(Matrix[] matrices) {
        for(int i = 0; i < matrices.length - 1; i++) {
            if (!(matrices[i].getDimensions().getY() == matrices[i+1].getDimensions().getX())) {
                return false;
            }
        }
        return true;
    }

    static void merge(final Comparable[] arr, Comparable[] aux, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        if (hi + 1 - lo >= 0) System.arraycopy(arr, lo, aux, lo, hi + 1 - lo);
        for (int s=lo; s<=hi; s++) {
            if (i > mid) {
                arr[s] = aux[j++];
            } else if (j > hi) {
                arr[s] = aux[i++];
            } else if (aux[i].compareTo(aux[j]) > 0) {
                arr[s] = aux[j++];
            } else {
                arr[s] = aux[i++];
            }
        }
    }
}
