package subarray;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author LiDaQian
 */
public class FindMaximumSubArrayTest {

    @Test
    public void testFind() {
        int[] array1 = new int[] {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, -7};
        int[] array2 = new int[] {13, 20, 18, 20, 24, 54, 56};

        SubArray rightSubArray1 = new SubArray(7, 10, 43);
        SubArray rightSubArray2 = new SubArray(0, 6, 205);

        SubArray subArray1 = FindMaximumSubArray.find(array1);
        SubArray subArray2 = FindMaximumSubArray.find(array2);

        Assert.assertEquals(rightSubArray1, subArray1);
        Assert.assertEquals(rightSubArray2, subArray2);
    }
}
