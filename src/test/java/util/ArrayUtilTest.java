package util;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author LiDaQian
 */
public class ArrayUtilTest {

    @Test
    public void testGenerateRandomArray() {
        int length = 10;
        int[] array = ArrayUtil.generateRandomArray(length);

        Assert.assertEquals(length, array.length);
    }

    @Test
    public void testExchange() {
        int[] array1 = ArrayUtil.generateRandomArray(5);

        int[] array2 = new int[array1.length];
        System.arraycopy(array1, 0, array2, 0, array2.length);
        array2[0] = array1[1];
        array2[1] = array1[0];

        ArrayUtil.exchange(array1, 0, 1);

        Assert.assertArrayEquals(array2, array1);
    }
}
