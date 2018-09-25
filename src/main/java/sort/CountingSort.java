package sort;

/**
 * @author LiDaQian
 */
public class CountingSort {

    /**
     * 计数器排序
     * 时间复杂度 O(n*lgn)
     * @param array 未排序数组
     */
    public static void sort(int[] array) {
        int[] countArray = makeCountingArray(array);

        int[] tempArray = new int[array.length];
        System.arraycopy(array, 0, tempArray, 0, array.length);

        for (int i = array.length - 1; i >= 0; i--) {
            array[countArray[tempArray[i]] - 1] = tempArray[i];
            countArray[tempArray[i]] = countArray[tempArray[i]] - 1;
        }
    }

    private static int[] makeCountingArray(int[] array) {
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > largest) {
                largest = array[i];
            }
        }
        int[] result = new int[largest + 1];
        // result[i]: =i个数
        for (int i = 0; i < array.length; i++) {
            result[array[i]] = result[array[i]] + 1;
        }
        // result[i]: <=i 的个数
        for (int i = 1; i < result.length; i++) {
            result[i] = result[i] + result[i - 1];
        }
        return result;
    }
}
