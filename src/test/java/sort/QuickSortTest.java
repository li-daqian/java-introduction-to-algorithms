package sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import util.ArrayUtil;

/**
 * @author LiDaQian
 */
public class QuickSortTest {

    @Test
    public void testSort() {
        int[] array = ArrayUtil.generateRandomArray(30);
        int[] arrayCopy = new int[array.length];
        System.arraycopy(array, 0, arrayCopy, 0, array.length);

        QuickSort.sort(array);
        Arrays.sort(arrayCopy);

        Assert.assertArrayEquals(array, arrayCopy);
    }
}
