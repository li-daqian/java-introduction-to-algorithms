package util;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author LiDaQian
 */
public class HeapUtilTest {

    @Test
    public void testBuildMaxHeap() {
        int[] array = {16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
        int[] maxHeapArray = {16, 14, 10, 8, 7, 9, 3, 2, 4, 1};

        HeapUtil.buildMaxHeap(array);

        Assert.assertArrayEquals(maxHeapArray, array);
    }

    @Test
    public void testMaxHeapify() {
        int[] array = {16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
        int[] afterMaxHeapifyArray = {16, 14, 10, 8, 7, 9, 3, 2, 4, 1};

        HeapUtil.maxHeapify(array, array.length, 1);

        Assert.assertArrayEquals(afterMaxHeapifyArray, array);
    }
}
