import com.saiftyfirst.Rhythm;
import com.saiftyfirst.Utilities;
import com.saiftyfirst.models.Matrix;
import org.junit.Test;

import java.util.Arrays;


public class UtilitiesTests {

    @Test
    public void MultiplicityTest() {
        Matrix[] matrices = new Matrix[3];
        matrices[0] = new Matrix(new Matrix.Dimensions(1, 3));
        matrices[1] = new Matrix(new Matrix.Dimensions(3, 2));
        matrices[2] = new Matrix(new Matrix.Dimensions(2, 4));
        assert Utilities.areMulipliable(matrices);
        matrices[1] = new Matrix(new Matrix.Dimensions(2, 2));
        assert !Utilities.areMulipliable(matrices);
    }

    @Test
    public void PermutationTest() {
        final int[] perm = new int[]{0, 1, 2, 5, 3, 3, 0};
        final int[] nextPerm = new int[]{0, 1, 3, 0, 2, 3, 5};
        int[] testPerm = perm.clone();
        assert Arrays.equals(nextPerm, Rhythm.NEXT_PERMUTATION(testPerm));
        assert Arrays.equals(perm, Rhythm.PREV_PERMUTATION(testPerm));
    }
}
