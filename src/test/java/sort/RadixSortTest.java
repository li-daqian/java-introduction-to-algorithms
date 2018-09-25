package sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import util.ArrayUtil;

/**
 * @author LiDaQian
 */
public class RadixSortTest {

    @Test
    public void testSort() {
        int[] array = ArrayUtil.generateRandomArray(20);
        int[] arrayCopy = new int[array.length];
        System.arraycopy(array, 0, arrayCopy, 0, array.length);

        CountingSort.sort(array);
        Arrays.sort(arrayCopy);

        Assert.assertArrayEquals(arrayCopy, array);
    }
}
