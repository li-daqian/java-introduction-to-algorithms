package sort;

/**
 * @author LiDaQian
 */
public class RadixSort {

    /**
     * 基数排序
     * @param array 未排序数组
     */
    public static void sort(int[] array) {
        // 数组中最大数位数
        int largestDigit = 0;
        for (int i = 0; i < array.length; i++) {
            int digit = 0;
            int num = array[i];
            while (num % 10 > 0) {
                digit++;
                num = num / 10;
            }
            if (digit > largestDigit) {
                largestDigit = digit;
            }
        }

        sort(array, largestDigit);
    }

    private static void sort(int[] array, int digit) {
        int[] tempArray = new int[array.length];
        System.arraycopy(array, 0, tempArray, 0, array.length);

        for (int i = 1; i <= digit; i++) {
            int[] countArray = makeCountArray(array, i);

            for (int j = array.length - 1; j >= 0; j--) {
                int index = tempArray[j] % (10 ^ digit);
                array[countArray[index] - 1] = tempArray[j];
                countArray[index] = countArray[index] - 1;
            }
        }
    }

    private static int[] makeCountArray(int[] array, int digit) {
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            int num = array[i] % (10 ^ digit);
            if (num > largest) {
                largest = num;
            }
        }

        int[] result = new int[largest + 1];
        for (int i = 0; i < array.length; i++) {
            int num = array[i] % (10 ^ digit);
            result[num] = result[num] + 1;
        }
        for (int i = 1; i < result.length; i++) {
            result[i] = result[i] + result[i - 1];
        }

        return result;
    }
}
