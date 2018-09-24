package queue;

import util.ArrayUtil;
import util.HeapUtil;

/**
 * @author LiDaQian
 */
public class PriorityQueue {

    private int[] array;
    private int heapSize;

    public PriorityQueue(int[] array) {
        this.array = array;
        this.heapSize = array.length;
        HeapUtil.buildMaxHeap(array);
    }

    /**
     * 添加元素
     * @param key 元素
     */
    public void insert(int key) {
        heapSize++;

        int[] newArray = new int[heapSize];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;

        array[heapSize - 1] = Integer.MIN_VALUE;
        increaseKey(heapSize - 1, key);
    }

    /**
     * 返回最大元素值
     * @return 最大元素值
     */
    public int heapMaximum() {
        return array[0];
    }

    /**
     * 返回最大元素值，并去掉此元素
     * @return 最大元素值
     */
    public int heapExtractMax() {
        if (heapSize == 0) {
            throw new IllegalStateException("heap underflow");
        }

        int max = heapMaximum();

        array[0] = array[heapSize - 1];
        heapSize--;
        HeapUtil.maxHeapify(array, heapSize, 0);

        return max;
    }

    /**
     * 增大元素值
     * @param index 下标
     * @param key 元素值
     */
    public void increaseKey(int index, int key) {
        if (key < array[index]) {
            throw new IllegalArgumentException("new key is smaller than current key");
        }
        array[index] = key;

        while (index > 0 && array[getParentIndex(index)] < array[index]) {
            ArrayUtil.exchange(array, getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    /**
     * 获取当前节点的父节点
     * @param index 当前节点
     * @return 父节点
     */
    private int getParentIndex(int index) {
        // 如果是偶数 是右节点
        // 反而 是左节点
        if (index % 2 == 0) {
            return (index - 2) / 2;
        } else {
            return (index - 1) / 2;
        }
    }

    public int[] getArray() {
        return array;
    }

    public int getHeapSize() {
        return heapSize;
    }
}
