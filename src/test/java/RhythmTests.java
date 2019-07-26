import com.saiftyfirst.Rhythm;
import com.saiftyfirst.models.graphs.Graph;
import com.saiftyfirst.models.graphs.UndirectedGraph;
import com.saiftyfirst.models.martices.Matrix;
import java.util.Arrays;
import lombok.Data;
import org.junit.Test;

public class RhythmTests {

    @Test
    // Check logs for results
    public void towerOfHanoiTest() {
        Rhythm.TOWER_OF_HANOI(3, 'A', 'B', 'C');
    }

    @Test
    public void maximalSubsetIndivisibleByKTest() {
        int[] testArr = {3, 17, 12, 9, 11, 15};
        int result = Rhythm.MAXIMAL_SUBSET_INDIVISIBLE_BY_K(testArr, 5);
        assert result == 4;
    }

    @Test
    public void matrixChainMultiplicationCostTest() {
        Matrix[] matrices = new Matrix[4];
        matrices[0] = new Matrix(new Matrix.Dimensions(3,2));
        matrices[1] = new Matrix(new Matrix.Dimensions(2,4));
        matrices[2] = new Matrix(new Matrix.Dimensions(4,2));
        matrices[3] = new Matrix(new Matrix.Dimensions(2,5));
        assert Rhythm.CHEAPEST_MATRIX_MULTIPLICATION(matrices).equals("((A(BC))D)");
    }


    @Test
    public void PermutationTest() {
        final int[] perm = new int[]{0, 1, 2, 5, 3, 3, 0};
        final int[] nextPerm = new int[]{0, 1, 3, 0, 2, 3, 5};
        int[] testPerm = perm.clone();
        assert Arrays.equals(nextPerm, Rhythm.NEXT_PERMUTATION(testPerm));
        assert Arrays.equals(perm, Rhythm.PREV_PERMUTATION(testPerm));
    }

    @Test
    public void setBitTest() {
        assert Rhythm.SET_BIT_COUNT(0) ==  0;
        assert Rhythm.SET_BIT_COUNT(1) ==  1;
        assert Rhythm.SET_BIT_COUNT(2) ==  1;
        assert Rhythm.SET_BIT_COUNT(3) ==  2;
        assert Rhythm.SET_BIT_COUNT(4) ==  1;
        assert Rhythm.SET_BIT_COUNT(5) ==  2;
        assert Rhythm.SET_BIT_COUNT(6) ==  2;
        assert Rhythm.SET_BIT_COUNT(7) ==  3;
        assert Rhythm.SET_BIT_COUNT(8) ==  1;
        assert Rhythm.SET_BIT_COUNT(9) ==  2;
        assert Rhythm.SET_BIT_COUNT(10) ==  2;
        assert Rhythm.SET_BIT_COUNT(11) ==  3;
        assert Rhythm.SET_BIT_COUNT(12) ==  2;
        assert Rhythm.SET_BIT_COUNT(13) ==  3;
        assert Rhythm.SET_BIT_COUNT(14) ==  3;
        assert Rhythm.SET_BIT_COUNT(15) ==  4;
        assert Rhythm.SET_BIT_COUNT(16) ==  1;
    }

    @Test
    public void eratosthenesSieveTest() {
        assert Rhythm.ERATOSTHENES_SIEVE(-1) == 0;
        assert Rhythm.ERATOSTHENES_SIEVE(1) == 0;
        assert Rhythm.ERATOSTHENES_SIEVE(20) == 8;
        assert Rhythm.ERATOSTHENES_SIEVE(1000) == 168;
        assert Rhythm.ERATOSTHENES_SIEVE(9876) == 1218;
    }

    @Test
    public void reverseArrayInplaceTest() {
        int[] arr1 = {1, 2, 3, 4, 7, 9};
        int[] arrRev1 = {9, 7, 4, 3, 2, 1};
        assert Arrays.equals(Rhythm.INPLACE_ARRAY_REVERSION(arr1), arrRev1);

        int[] arr2 = {13, 10, 12, 15, 9, 8};
        int[] arrRev2 = {8, 9, 15, 12, 10, 13};
        assert Arrays.equals(Rhythm.INPLACE_ARRAY_REVERSION(arr2), arrRev2);

        int[] arr3 = {2,42, 0, 42, 2};
        int[] arrRev3 = {2,42, 0, 42, 2};
        assert Arrays.equals(Rhythm.INPLACE_ARRAY_REVERSION(arr3), arrRev3);

        int[] arr4 = {1};
        int[] arrRev4 = {1};
        assert Arrays.equals(Rhythm.INPLACE_ARRAY_REVERSION(arr4), arrRev4);

        int[] arr5 = {3, 3, 4, 7};
        int[] arrRev5 = {7, 4, 3, 3};
        assert Arrays.equals(Rhythm.INPLACE_ARRAY_REVERSION(arr5), arrRev5);
    }

    @Test
    public void postfixEvaluationTest() {
        String expression = "100 200 + 2 / 5 * 7 +";
        assert Rhythm.POSTFIX_EVALUATION(expression.toCharArray()) == 757.0;
    }

    @Test
    public void mergeSortTest() {
        Comparable[] result = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Comparable[] arr1 = {10, 9, 8, 7, 6, 5, 4, 3, 2 , 1};
        Rhythm.MERGE_SORT(arr1);
        assert Arrays.equals(arr1, result);

        Comparable[] arr2 = {7, 9, 2, 4, 3, 1, 10, 5, 8, 6};
        Rhythm.MERGE_SORT(arr2);
        assert Arrays.equals(arr2, result);
    }

    @Test
    public void minSwapSortTest() {
        int[] arr1 = {4, 3, 1, 2};
        assert Rhythm.MINIMUM_SWAPS_TO_SORT(arr1) == 3;

        int[] arr2 = {1, 3, 5, 2, 4, 6, 7};
        assert Rhythm.MINIMUM_SWAPS_TO_SORT(arr2) == 3;

        // Remainder of the test including large input test on HackerRank.
    }

    @Test
    public void anagramTest() {
        Rhythm.SHERLOCK_AND_ANAGRAMS("cdcd");
    }

    @Test
    public void dfsTest() {
        UndirectedGraph undirectedGraph = new UndirectedGraph(10);
        undirectedGraph.addEdge(0,1);
        undirectedGraph.addEdge(0,2);
        undirectedGraph.addEdge(1,2);
        undirectedGraph.addEdge(1,4);
        undirectedGraph.addEdge(1,9);
        undirectedGraph.addEdge(2,3);
        undirectedGraph.addEdge(2,9);
        undirectedGraph.addEdge(3,8);
        undirectedGraph.addEdge(4,8);
        undirectedGraph.addEdge(4,9);
        undirectedGraph.addEdge(5,6);

        final String[] labels = new String[] {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

        String result = Rhythm.DFS(undirectedGraph, 2, labels);
        assert result.equals("CABDJEI");

        result = Rhythm.DFS(undirectedGraph, 4, labels);
        assert result.equals("EBIJACD");

        result = Rhythm.DFS(undirectedGraph, 5, labels);
        assert result.equals("FG");

        result = Rhythm.DFS(undirectedGraph, 7, labels);
        assert result.equals("H");

    }



}
