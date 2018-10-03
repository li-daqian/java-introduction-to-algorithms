package dynamicprogramming;

/**
 * 动态规划 最优子结构
 * @author LiDaQian
 */
public class OptimalSubstructure {

    public static int cutRod(int[] array, int length) {
        if (length == 0) {
            return 0;
        }

        int result = Integer.MIN_VALUE;
        for (int i = 1; i <= length; i++) {
            result = Math.max(result, array[i] + cutRod(array, length - i));
        }

        return result;
    }
}
