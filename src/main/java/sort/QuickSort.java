package sort;

import util.ArrayUtil;

/**
 * @author LiDaQian
 */
public class QuickSort {

    /**
     * 快速排序
     * 时间复杂度 O(n*lgn)
     * @param array 未排序数组
     */
    public static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }

        // 确定中轴数位置，中轴数左边数字 <= 中轴数 中轴数右边数字 >= 中轴数
        int partitionIndex = partition(array, low, high);
        // 排序中轴数左部分
        sort(array, low, partitionIndex - 1);
        // 排序中轴数右部分
        sort(array, partitionIndex + 1, high);
    }

    private static int partition(int[] array, int low, int high) {
        int pivotElement = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] <= pivotElement) {
                i++;
                ArrayUtil.exchange(array, i, j);
            }
        }

        ArrayUtil.exchange(array, i + 1, high);
        return i + 1;
    }
}
