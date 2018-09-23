package sort;

/**
 * @author LiDaQian
 */
public class MergeSort {

    /**
     * 归并排序
     * 时间 O(nlgn)
     * @param array
     */
    public static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int head, int tail) {
        if (head >= tail) {
            return;
        }

        int middle = (head + tail) / 2;

        // 排序左数组
        sort(array, head, middle);
        // 排序右数组
        sort(array, middle + 1, tail);
        // 合并已排序的数组
        merge(array, head, middle, tail);
    }

    private static void merge(int[] array, int begin, int middle, int end) {
        int leftArrayLength = middle - begin + 1;
        int rightArrayLength = end - middle;

        int[] leftArray = new int[leftArrayLength + 1];
        int[] rightArray = new int[rightArrayLength + 1];

        System.arraycopy(array, begin, leftArray, 0, leftArrayLength);
        System.arraycopy(array, middle + 1, rightArray, 0, rightArrayLength);

        leftArray[leftArrayLength] = Integer.MAX_VALUE;
        rightArray[rightArrayLength] = Integer.MAX_VALUE;

        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = begin; i <= end; i++) {
            if (leftArray[leftIndex] <= rightArray[rightIndex]) {
                array[i] = leftArray[leftIndex];
                leftIndex++;
            } else {
                array[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
    }
}
