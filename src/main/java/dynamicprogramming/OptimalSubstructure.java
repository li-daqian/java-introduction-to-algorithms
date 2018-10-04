package dynamicprogramming;

/**
 * 动态规划 最优子结构
 * @author LiDaQian
 */
public class OptimalSubstructure {

    /**
     * 钢条切割-自顶向下递归实现
     * @param array 钢筋长度价格表
     * @param length 需要切割的钢筋长度
     * @return 钢筋最大价格
     */
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

    /**
     * 钢条切割-动态规划 自顶向下带备忘实现
     * @param array 钢筋长度价格表
     * @param length 需要切割的钢筋长度
     * @return 钢筋最大价格
     */
    public static int memoizedCutRod(int[] array, int length) {
        int[] answer = new int[length + 1];
        for (int i = 1; i < answer.length; i++) {
            answer[i] = Integer.MIN_VALUE;
        }

        return memoizedCutRodAux(array, length, answer);
    }

    /**
     * 钢条切割-动态规划 自底向上
     * @param array 钢筋长度价格表
     * @param length 需要切割的钢筋长度
     * @return 钢筋最大价格
     */
    public static int bottomUpCutRod(int[] array, int length) {
        int[] answer = new int[length + 1];
        answer[0] = 0;

        for (int i = 1; i <= length; i++) {
            int result = Integer.MIN_VALUE;
            for (int j = 1; j <= i; j++) {
                result = Math.max(result, array[j] + answer[i - j]);
            }
            answer[i] = result;
        }

        return answer[length];
    }

    public static void printCutRodSolution(int[] array, int length) {
        BestSolution bestSolution = extendedBottomUpCutRod(array, length);
        while (length > 0) {
            System.out.println(bestSolution.s[length]);
            length = length - bestSolution.s[length];
        }
    }

    private static BestSolution extendedBottomUpCutRod(int[] array, int length) {
        BestSolution bestSolve = new BestSolution();
        int[] r = new int[length + 1];
        int[] s = new int[length + 1];
        bestSolve.r = r;
        bestSolve.s = s;
        r[0] = 0;

        for (int i = 1; i <= length; i++) {
            int q = Integer.MIN_VALUE;
            for (int j = 1; j <= i; j++) {
                if (q < (array[j] + r[i - j])) {
                    q = array[j] + r[i - j];
                    s[i] = j;
                }
            }
            r[i] = q;
        }
        return bestSolve;
    }

    private static int memoizedCutRodAux(int[] array, int length, int[] answer) {
        if (answer[length] >= 0) {
            return answer[length];
        }

        int q = 0;
        if (length == 0) {
            q = 0;
        } else {
            q = Integer.MIN_VALUE;
            for (int i = 1; i <= length; i++) {
                q = Math.max(q, array[i] + memoizedCutRodAux(array, length - i, answer));
            }
        }
        answer[length] = q;

        return q;
    }

    static class BestSolution {
        int[] r;
        int[] s;
    }
}
