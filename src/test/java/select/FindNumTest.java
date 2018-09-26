package select;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author LiDaQian
 */
public class FindNumTest {

    @Test
    public void testFindMinimum() {
        int[] array = {11, 2324, 4, 12, 432, 1, 0, -1, 4};

        int minimum = FindNum.findMinimum(array);

        Assert.assertEquals(-1, minimum);
    }

    @Test
    public void testFindMinMax() {
        int[] array1 = {11, 2324, 4, 12, 432, 1, 0, -1, 4};
        int[] array2 = {11, 0, 4, 12, 432, 1, 0, -1, 4, -10};

        int[] minMax1 = FindNum.findMinMax(array1);
        int[] minMax2 = FindNum.findMinMax(array2);

        Assert.assertArrayEquals(new int[]{-1, 2324}, minMax1);
        Assert.assertArrayEquals(new int[]{-10, 432}, minMax2);
    }
}
