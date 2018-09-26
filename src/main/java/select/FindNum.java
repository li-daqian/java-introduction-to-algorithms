package select;

/**
 * @author LiDaQian
 */
public class FindNum {

    /**
     * 找到数组中最小数
     * @param array 数组
     * @return 最小数
     */
    public static int findMinimum(int[] array) {
        int minimum = array[0];

        for (int i = 1; i < array.length; i++) {
            if (minimum > array[i]) {
                minimum = array[i];
            }
        }
        return minimum;
    }

    /**
     * 找到数组中最小值和最大值
     * @param array 数组
     * @return 最小值和最大值的数组
     */
    public static int[] findMinMax(int[] array) {
        int[] result = new int[2];
        int startIndex;
        if (array.length > 2 && array.length % 2 == 0) {
            if (array[0] > array[1]) {
                result[0] = array[1];
                result[1] = array[0];
            } else {
                result[0] = array[0];
                result[1] = array[1];
            }
            startIndex = 2;
        } else {
            result[0] = array[0];
            startIndex = 1;
        }

        for (int i = startIndex; i < array.length; i += 2) {
            int tempMin;
            int tempMax;
            if (array[i] < array[i + 1]) {
                tempMin = array[i];
                tempMax = array[i + 1];
            } else {
                tempMin = array[i + 1];
                tempMax = array[i];
            }

            if (tempMin < result[0]) {
                result[0] = tempMin;
            }
            if (tempMax > result[1]) {
                result[1] = tempMax;
            }
        }

        return result;
    }
}
