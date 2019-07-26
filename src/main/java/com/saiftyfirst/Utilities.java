package com.saiftyfirst;

import com.saiftyfirst.models.martices.Matrix;

public class Utilities {

    static int maximum(int a, int b) {
        if (a >= b) return a;
        else return b;
    }

    static int minimum(int a, int b) {
        if (a <= b) return a;
        else return b;
    }

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
        for (int s=lo; s<=hi; s++) {
            aux[s] = arr[s];
        }
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
