package com.saiftyfirst;

import com.saiftyfirst.models.Operator;
import com.saiftyfirst.models.matrix.Matrix;

import java.util.Arrays;
import java.util.Stack;

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

    public static int SET_BIT_COUNT(int number) {
        /**
         * 1st key idea: Take a truth table of any length. Notice how subtracting 1 from any value,
         * toggles all rightmost bits in the number up to and including the first set bit.
         * Example: 1101 -> 1100, 1000 -> 0111 etc.
         *
         * 2nd key idea: Using the knowledge from idea 1, if you do a bitwise AND of n and
         * n - 1, the rightmost set bit and all after it are unset. This means, you could potentially
         * do this process upto the number of set bits in the number before the number becomes 0.
         *
         * Food for thought: What would change if you were asked to get the number of 0s in a
         * number given that you are provided with an upper bound for the number.
         * 1. Think addition of 1.
         * 2. Think toggle after and including rightmost unset(0) bit.
         * 3. Think OR ;).
         * Acknowledgement: Brian Kernighan
         */

        int count = 0;
        while (number > 0) {
            count ++;
            number &= (number - 1);
        }
        return count;
    }

    public static int ERATOSTHENES_SIEVE(int number) {
        /**
         * Tribute to Eratosthenes of Cyrene.
         *
         * Starting at 2 (first prime) mark out all multiples.
         * Increment till next non-marked found which is the next prime and continue till number passed as param.
         * Hint: If you find an unmarked number, if it was not a prime then by definition, it should have a number
         *       than itself(not 1) that can divide itself. This is not possible, as we have already marked all multiples of
         *       all lower numbers.
         *
         * Indexes 0 and 1 will always say False but we specifically discount them before return.
         * Another interesting feature of the algorithm is how we limit the outer loop by sqrt of number and start the
         * inner loop with square root of the prime. This is because, every composite number has at least one prime
         * factor that is not greater than it's square root(Intuitive if you think about it a bit).
         */
        boolean[] nonPrimes = new boolean[number + 1];
        int primeCount = 0;
        for (int i = 2; i*i <= number; i++) {
            if (!nonPrimes[i]) {
                for (int j = i*i; j <= number; j+=i) {
                    nonPrimes[j] = true;
                }
            }
        }
        for (int i =2; i <= number; i++) {
            primeCount += !nonPrimes[i] ? 1 : 0;
        }
        return primeCount;
    }

    public static int[] INPLACE_ARRAY_REVERSION(int[] array) {
        /**
         * Reversing an array without creating a new one.
         * Two pointers, once each at the start(=i) and end(=j) of array.
         * While i is at a lower array index than j,
         * - Switch the values at the two pointed array positions
         * - Increment pointer i
         * - Decrement pointer j
         * return the array
         * Shout Out: Nikolas Tek
         */
        int i = 0;
        int j = array.length - 1;
        int temp;
        while (i < j) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
        return array;
    }

    public static double POSTFIX_EVALUATION(final char[] expression) {
        /**
         * Key idea is to push operands onto the stack. When an operator is encountered, two operands are popped
         * from the stack and the result is pushed back. At the end, what is left in the stack is the result.
         */
        Stack<Double> operandStack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        Operator operator;
        double secondOperand;
        for (char c : expression) {
            if (c != ' ') {
                builder.append(c);
            } else {
                operator = Operator.getOperatorByCode(builder.toString().charAt(0));
                if (operator != null) {
                    secondOperand = operandStack.pop();
                    operandStack.push(operator.apply(operandStack.pop(), secondOperand));
                } else {
                    operandStack.push(Double.valueOf(builder.toString()));
                }
                builder.setLength(0);
            }
        }
        secondOperand = operandStack.pop();
        return Operator.getOperatorByCode(builder.toString().charAt(0)).apply(operandStack.pop(), secondOperand);
    }

    public static void MERGE_SORT(Comparable[] array) {
        /**
         * Bottom up merge sort implementation.
         * Divide the array into sub-arrays with length of incremental power of 2 starting a 2 upto half of original
         * length. Merge each sub-array.
         */
        int len = array.length;
        Comparable[] aux = new Comparable[len];
        for (int size = 1; size < len; size += size) {
            for (int i =0; i < len - size; i += size*2) {
                Utilities.merge(array, aux, i, i + size -1, Utilities.minimum(i + size*2 - 1, len - 1));
            }
        }
    }

}
