package com.saiftyfirst;

import java.util.Arrays;
import java.util.List;

public class Rhythm {

    public static void TOWER_OF_HANOI(int numOfDiscs, char source, char inter, char to) {
        if (numOfDiscs == 1) {
            System.out.println("Move disc 1 from " + source + " to " + to);
            return;
        }
        TOWER_OF_HANOI(numOfDiscs - 1, source, to, inter);
        System.out.println("Move disc " + numOfDiscs + " from " + source + " to " + to);
        TOWER_OF_HANOI(numOfDiscs - 1, inter, source, to);
    }

    public static int LONGEST_SHARED_SUBSTRING(final String str1, final String str2) {
        int ret = 0;
        final int lengthStr1 = str1.length();
        final int lengthStr2 = str2.length();

        char[] charArrayStr1 = str1.toCharArray();
        char[] charArrayStr2 = str2.toCharArray();

        int sequenceGrid[][] = new int[lengthStr1 + 1][lengthStr2 + 1];

        for (int i = 0; i < lengthStr1; i++) {
            for (int j = 0; j < lengthStr2; j++) {
                if (i == 0 || j ==0){
                    sequenceGrid[i][j] = 0;
                } else if (charArrayStr1[i-1] == charArrayStr2[j-1]) {
                    sequenceGrid[i][j] = sequenceGrid[i-1][j-1] + 1;
                    ret = Utilities.maximum(ret, sequenceGrid[i][j]);
                } else {
                    sequenceGrid[i][j] = 0;
                }
            }
        }
        return ret;
    }

    public static int MAXIMAL_SUBSET_INDIVISIBLE_BY_K(int[] arr, int k) {
        int[] moduloArray = new int[k];
        Arrays.fill(moduloArray, 0);
        for (int i: arr) {
            moduloArray[i % k]++;
        }
        int ret = moduloArray[0] > 0 ? 1 : 0;
        for (int i = 1; i <= k/2 ; i++) {
            ret += Utilities.maximum(moduloArray[i], moduloArray[k-i]);
        }
        return ret;
    }


    public static List<String> CHEAPEST_MATRIX_MULTIPLICATION() {
        return null;
    }

}
