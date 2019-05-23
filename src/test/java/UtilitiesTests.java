import com.saiftyfirst.Utilities;
import com.saiftyfirst.models.Matrix;
import org.junit.Test;


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

}
