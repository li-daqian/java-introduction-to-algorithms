package sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import util.ArrayUtil;

/**
 * @author LiDaQian
 */
public class HeapSortTest {

    @Test
    public void testSort() {
        int[] randArray1 = ArrayUtil.generateRandomArray(10);
        int[] randArray2 = ArrayUtil.generateRandomArray(15);

        int[] randArrayCopy1 = new int[randArray1.length];
        int[] randArrayCopy2 = new int[randArray2.length];
        System.arraycopy(randArray1, 0, randArrayCopy1, 0, randArray1.length);
        System.arraycopy(randArray2, 0, randArrayCopy2, 0, randArray2.length);

        HeapSort.sort(randArray1);
        HeapSort.sort(randArray2);

        Arrays.sort(randArrayCopy1);
        Arrays.sort(randArrayCopy2);

        Assert.assertArrayEquals(randArrayCopy1, randArray1);
        Assert.assertArrayEquals(randArrayCopy2, randArray2);
    }
}
