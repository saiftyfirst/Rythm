package com.saiftyfirst;

import com.saiftyfirst.models.Matrix;

import java.util.Arrays;

public class Rhythm {

    public static void TOWER_OF_HANOI(final int numOfDiscs, final char source, final char inter, final char to) {
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

        /**
         * Dummy grid value at [0][0] for ease of indexing in algo
         */
        int sequenceGrid[][] = new int[lengthStr1 + 1][lengthStr2 + 1];

        /**
         * Fill a grid of str1.len x str2.len comparing each character at i for str1 and j for str2.
         * The value for each grid item is grid[i-1][j-1] + 1 in case of char match.
         * The value is 0 in case of a non-match.
         * Keeping track of the highest encountered value, gives the longest sequence.
         */
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

    public static int MAXIMAL_SUBSET_INDIVISIBLE_BY_K(final int[] arr, final int k) {
        /**
         * Create an array holding module counts from the set of numbers.
         * Loop through half the array, picking the number higher between two complements that would result in module
         * summation of 3.
         * For example, in case k=7, we pick the higher of ModuloArray[3] or ModuloArray[4] but not both (or we get sum of 7).
         * Edge scenario: We can always pick one item that is divisible by 7 but not more.
         */
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

    /**
     * C[i,j] = Min(i <= k < j) { C[i,k] + C[k+1,j] + d(i-1) + d(k) + d(j)}
     */
    public static String CHEAPEST_MATRIX_MULTIPLICATION(final Matrix[] matrices) {
        /**
         * Maintain a costMatrix of len x len. Store the min value of C[i,j] in corresponding position.
         * We use a bottom up approach starting at [1,1]/[0,0] depending on indexing used.
         * Maintain a kMatrix which holds the k for which cost is minimized in corresponding position.
         */
        if (Utilities.areMulipliable(matrices)) {
            int lenOfMatrices = matrices.length;
            int[] dimensions = new int[lenOfMatrices + 1];
            int[][] costMatrix = new int[lenOfMatrices][lenOfMatrices];
            int[][] minKMatrix = new int[lenOfMatrices][lenOfMatrices];
            dimensions[0] = matrices[0].getDimensions().getX();
            for (int i = 0; i < lenOfMatrices; i++) {
                dimensions[i+1] = matrices[i].getDimensions().getY();
            }
            int cost;
            int minCost;
            int j;
            for (int diff = 1; diff < lenOfMatrices; diff++){
                for (int i = 0; i + diff < lenOfMatrices; i++) {
                    j = i + diff;
                    minCost = 0;
                    for (int k = i; k < j; k++){
                        cost = costMatrix[i][k] + costMatrix[k+1][j] +
                                dimensions[i] * dimensions[k+1] * dimensions[j+1];
                        if (cost < minCost || minCost == 0) {
                            minCost = cost;
                            costMatrix[i][j] = minCost;
                            minKMatrix[i][j] = k;
                        }
                    }
                }
            }
            return parenthesisOrderForMCM(0, lenOfMatrices - 1, minKMatrix);
        } else {
            return null;
        }
    }

    static String parenthesisOrderForMCM(final int i, final int j, final int minKMatrix[][]) {
        /**
         * Recursively find the position of the brackets using the k from the kMatrix.
         */
        StringBuilder builder = new StringBuilder();
        if (i == j) {
            builder.append((char)(i + 65));
            return builder.toString();
        }
        builder.append("(");
        builder.append(parenthesisOrderForMCM(i, minKMatrix[i][j], minKMatrix));
        builder.append(parenthesisOrderForMCM(minKMatrix[i][j] + 1, j, minKMatrix));
        builder.append(")");
        return builder.toString();
    }

    public static int[] NEXT_PERMUTATION(int sequence[]) {
        /**
         * Key idea is to think of suffixes.
         * Look at the end of the sequence and determine the longest non-increasing sequence.
         * Say, start of such a suffix is at index i, then position i-1 is the pivot.
         * Replace the pivot with the lowest number in sequence bigger than pivot.
         * Invert the suffix to ensure that the change in sequence is minimized.
         */
        int i = sequence.length - 1;
        while (i >= 0 && sequence[i-1] >= sequence[i]) i--;
        if (i == 0) return sequence;
        int j = sequence.length - 1;
        while (sequence[j] <= sequence[i-1]) j--;
        int temp = sequence[j];
        sequence[j] = sequence[i-1];
        sequence[i-1] = temp;
        j = sequence.length - 1;
        while (j > i) {
            temp = sequence[i];
            sequence[i++] = sequence[j];
            sequence[j--] = temp;
        }
        return sequence;
    }

    public static int[] PREV_PERMUTATION(int sequence[]) {
        /**
         * Key idea is to think of suffixes.
         * Look at the end of the sequence and determine the longest non-decreasing sequence.
         * Say, start of such a suffix is at index i, then position i-1 is the pivot.
         * Replace the pivot with the largest number in sequence less than pivot.
         * Invert the suffix to ensure that the change in sequence is minimized.
         */
        int i = sequence.length - 1;
        while (i >= 0 && sequence[i-1] <= sequence[i]) i--;
        if (i == 0) return sequence;
        int j = sequence.length - 1;
        while (sequence[j] >= sequence[i-1]) j--;
        int temp = sequence[j];
        sequence[j] = sequence[i-1];
        sequence[i-1] = temp;
        j = sequence.length - 1;
        while (j > i) {
            temp = sequence[i];
            sequence[i++] = sequence[j];
            sequence[j--] = temp;
        }
        return sequence;
    }

}
