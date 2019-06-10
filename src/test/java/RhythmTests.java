import com.saiftyfirst.Rhythm;
import com.saiftyfirst.Utilities;
import com.saiftyfirst.models.matrix.Matrix;
import java.util.Arrays;
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

}
