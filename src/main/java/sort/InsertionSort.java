package sort;

/**
 * @author LiDaQian
 */
public class InsertionSort {

    /**
     * 插入排序
     * 时间 O(n²)
     * @param array 未排序数组
     */
    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];

            int j = i - 1;
            // 把最小数插入至数组最左边
            while (j > -1 && array[j] > key) {
                array[j + 1] = array[j];
                array[j] = key;
                j--;
            }
        }
    }
}
