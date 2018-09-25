package sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import util.ArrayUtil;

/**
 * @author LiDaQian
 */
public class CountingSortTest {

    @Test
    public void testSort() {
        int[] array = ArrayUtil.generateRandomArray(10);
        int[] arrayCopy = new int[array.length];
        System.arraycopy(array, 0, arrayCopy, 0, array.length);

        CountingSort.sort(array);
        Arrays.sort(arrayCopy);

        Assert.assertArrayEquals(arrayCopy, array);
    }
}
