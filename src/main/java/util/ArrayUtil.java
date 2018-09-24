package util;

import java.util.Random;

/**
 * @author LiDaQian
 */
public class ArrayUtil {

    private static final Random RANDOM = new Random();

    /**
     * 生成随机数组
     * @param length 数组长度
     * @return 随机数组
     */
    public static int[] generateRandomArray(int length) {
        int[] randomArray = new int[length];
        for (int i = 0; i < length; i++) {
            int num = RANDOM.nextInt(100);
            randomArray[i] = num;
        }

        return randomArray;
    }

    /**
     * 交换数组中的两个数
     * @param array 数组
     * @param a 下标
     * @param b 下标
     */
    public static void exchange(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
