import com.saiftyfirst.Rhythm;
import com.saiftyfirst.models.Matrix;
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
}
