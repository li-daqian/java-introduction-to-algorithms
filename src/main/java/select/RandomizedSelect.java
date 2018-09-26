package select;

import java.util.Random;

import util.ArrayUtil;

/**
 * @author LiDaQian
 */
public class RandomizedSelect {

    /**
     * 挑选数组中 第i小元素
     * @param array 数组
     * @param i 第几小
     * @return 第i小元素
     */
    public static int select(int[] array, int i) {
        if (i > array.length) {
            throw new IllegalArgumentException("i: " + i + " granter than array.length: " + array.length);
        }
        return select(array, 0, array.length - 1, i);
    }

    private static int select(int[] array, int left, int right, int i) {
        if (left == right) {
            return array[left];
        }
        // 获取中轴数下标
        int k = randomizedPartition(array, left, right);
        if (k == i - left - 1) {
            // 命中
            return array[k];
        } else if (i - left - 1 < k) {
            // 下标在中轴数左侧
            return select(array, left, k - 1, i);
        } else {
            // 下标在中轴数右侧
            return select(array, k + 1, right, i - k);
        }
    }

    /**
     * 随机挑选中轴数，并返回中轴数下标， 中轴数左侧都小于中轴数， 中轴数右侧都大于中轴数
     * @param array 数组
     * @param left 左下标
     * @param right 右下标
     * @return 中轴数下标
     */
    private static int randomizedPartition(int[] array, int left, int right) {
        int randomI = new Random().nextInt(right - left) + left;
        ArrayUtil.exchange(array, randomI, right);

        int key = array[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (array[j] < key) {
                i++;
                ArrayUtil.exchange(array, i, j);
            }
        }
        ArrayUtil.exchange(array, i + 1, right);
        return i + 1;
    }
}
