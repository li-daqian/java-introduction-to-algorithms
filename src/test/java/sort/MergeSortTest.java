package sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import util.ArrayUtil;

/**
 * @author LiDaQian
 */
public class MergeSortTest {

    @Test
    public void testNormalArray() {
        int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] array2 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] array3 = {1};
        int[] array4 = {2, 1};

        int[] sortedArray1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] sortedArray2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] sortedArray3 = {1};
        int[] sortedArray4 = {1, 2};

        MergeSort.sort(array1);
        MergeSort.sort(array2);
        MergeSort.sort(array3);
        MergeSort.sort(array4);

        Assert.assertArrayEquals(sortedArray1, array1);
        Assert.assertArrayEquals(sortedArray2, array2);
        Assert.assertArrayEquals(sortedArray3, array3);
        Assert.assertArrayEquals(sortedArray4, array4);
    }

    @Test
    public void testRandomArray() {
        int[] randArray1 = ArrayUtil.generateRandomArray(4);
        int[] randArray2 = ArrayUtil.generateRandomArray(9);

        int[] randArrayCopy1 = new int[randArray1.length];
        int[] randArrayCopy2 = new int[randArray2.length];
        System.arraycopy(randArray1, 0, randArrayCopy1, 0, randArray1.length);
        System.arraycopy(randArray2, 0, randArrayCopy2, 0, randArray2.length);

        InsertionSort.sort(randArray1);
        InsertionSort.sort(randArray2);

        Arrays.sort(randArrayCopy1);
        Arrays.sort(randArrayCopy2);

        Assert.assertArrayEquals(randArrayCopy1, randArray1);
        Assert.assertArrayEquals(randArrayCopy2, randArray2);

    }
}
