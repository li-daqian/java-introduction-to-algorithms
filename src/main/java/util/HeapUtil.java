package util;

/**
 * @author LiDaQian
 */
public class HeapUtil {

    /**
     * 构建最大堆
     * @param array 原数组
     */
    public static void buildMaxHeap(int[] array) {
        for (int i = (array.length) / 2; i >= 0; i--) {
            HeapUtil.maxHeapify(array, array.length, i);
        }
    }

    /**
     * 最大堆 自适应调整
     * @param array 最大堆
     * @param heapSize 当前元素数量
     * @param index 要调整的节点
     */
    public static void maxHeapify(int[] array, int heapSize, int index) {
        int leftIndex = getLeftIndex(index);
        int rightIndex = getRightIndex(index);

        // 从 根节点、左节点、右节点 找到最大值
        int largestIndex = index;
        if (leftIndex <= heapSize - 1 && array[leftIndex] > array[index]) {
            largestIndex = leftIndex;
        }
        if (rightIndex <= heapSize - 1 && array[rightIndex] > array[largestIndex]) {
            largestIndex = rightIndex;
        }
        // 符合最大堆要求
        if (largestIndex == index) {
            return;
        }
        // 交换两节点
        ArrayUtil.exchange(array, index, largestIndex);
        // 递归调整最大堆
        maxHeapify(array, heapSize, largestIndex);
    }

    /**
     * 获取堆左节点
     * @param index 父节点
     * @return
     */
    private static int getLeftIndex(int index) {
        return index * 2 + 1;
    }

    /**
     * 获取堆右节点
     * @param index 父节点
     * @return
     */
    private static int getRightIndex(int index) {
        return index * 2 + 2;
    }
}
