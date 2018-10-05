package dynamicprogramming;

/**
 * @author LiDaQian
 */
public class Commonsubsequence {

    public static void printLcs(int[][] b, String[] x, int i, int j) {
        if (i == 0 || j == 0) {
            return;
        }
        if (b[i][j] == Lcs.EQUALS) {
            printLcs(b, x, i - 1, j -1);
            System.out.print(x[i - 1]);
        } else if (b[i][j] == Lcs.GREATER_THAN) {
            printLcs(b, x, i - 1, j);
        } else {
            printLcs(b, x, i, j - 1);
        }
    }

    public static Lcs lcsLength(String[] x, String[] y) {
        int m = x.length + 1;
        int n = y.length + 1;
        int[][] b = new int[m][n];
        int[][] c = new int[m][n];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (x[i - 1].equals(y[j - 1])) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    b[i][j] = Lcs.EQUALS;
                } else if (c[i - 1][j] >= c[i][j - 1]) {
                    c[i][j] = c[i - 1][j];
                    b[i][j] = Lcs.GREATER_THAN;
                } else {
                    c[i][j] = c[i][j - 1];
                    b[i][j] = Lcs.LESS_THAN;
                }
            }
        }

        Lcs lcs = new Lcs(c, b);
        return lcs;
    }

    static class Lcs {
        static final int EQUALS = 1;
        static final int GREATER_THAN = 2;
        static final int LESS_THAN = 3;
        // lcs长度记录表
        int[][] c;
        // 帮助构造最优解
        int[][] b;

        Lcs(int[][] c, int[][] b) {
            this.c = c;
            this.b = b;
        }
    }
}
