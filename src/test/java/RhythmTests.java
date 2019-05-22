import com.saiftyfirst.Rhythm;
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
}
