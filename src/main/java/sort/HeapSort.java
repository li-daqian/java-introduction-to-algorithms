package sort;

import util.ArrayUtil;
import util.HeapUtil;

/**
 * @author LiDaQian
 */
public class HeapSort {
    /**
     * 当前堆节点数量
     */
    private static ThreadLocal<Integer> heapSize = new ThreadLocal<>();

    /**
     * 最大堆排序
     * 时间复杂度 O(n*lgn)
     * @param array
     */
    public static void sort(int[] array) {
        // 构建最大堆
        HeapUtil.buildMaxHeap(array);
        heapSize.set(array.length);
        // 最大堆排序
        for (int i = array.length - 1; i >= 1; i--) {
            ArrayUtil.exchange(array, 0, i);
            heapSize.set(heapSize.get() - 1);
            HeapUtil.maxHeapify(array, heapSize.get(), 0);
        }
    }
}
