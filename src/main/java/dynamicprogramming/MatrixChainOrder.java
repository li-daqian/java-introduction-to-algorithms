package dynamicprogramming;

/**
 * @author LiDaQian
 */
public class MatrixChainOrder {

    public static void printOptimalParens(int[][] s, int i, int j) {
        if (i == j) {
            System.out.print("A" + (i + 1));
        } else {
            System.out.print("(");
            printOptimalParens(s, i, s[i][j]);
            printOptimalParens(s, s[i][j] + 1, j);
            System.out.print(")");
        }
    }

    public static Result order(int[] p) {
        int n = p.length - 1;
        int[][] m = new int[p.length][p.length];
        int[][] s = new int[p.length][p.length];

        for (int l = 2; l <= n; l++) {
            for (int i = 1; i <= n - l + 1; i++) {
                int j = i + l - 1;
                /*
                i = 2, j = 5
                m[2][5] = min(m[2][2] + m[3][5] + q[1] * p[2] * p[5],
                              m[2][3] + m[4][5] + q[1] * p[3] * p[5],
                              m[2][4] + m[5][5] + q[1] * p[4] * p[5])

                */
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }

        Result result = new Result();
        result.m = m;
        result.s = s;

        return result;
    }

    static class Result {
        int[][] m;
        int[][] s;
    }
}
