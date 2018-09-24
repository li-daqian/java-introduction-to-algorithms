package matrix;

/**
 * @author LiDaQian
 */
public class SquareMatrix {

    /**
     * 正方形矩阵乘法
     * 时间复杂度 O(n^3)
     */
    public static int[][] multiply(int[][] a, int[][] b) {
        int[][] result = new int[a.length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                result[i][j] = 0;
                for (int k = 0; k < a.length; k++) {
                    result[i][j] = result[i][j] + a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }

    /**
     * strassen矩阵乘法
     * 时间复杂度 O(n^lg7)
     */
    public static int[][] strassenMultiply(int[][] a, int[][] b) {
        int n = a.length;
        int[][] result = new int[n][n];

        if (n == 1) {
            result[0][0] = a[0][0] * b[0][0];
        } else {
            // 分解矩阵
            int[][] A11 = divide(a, 0, 0);
            int[][] A12 = divide(a, 0, n / 2);
            int[][] A21 = divide(a, n / 2, 0);
            int[][] A22 = divide(a, n / 2, n / 2);

            int[][] B11 = divide(b, 0, 0);
            int[][] B12 = divide(b, 0, n / 2);
            int[][] B21 = divide(b, n / 2, 0);
            int[][] B22 = divide(b, n / 2, n / 2);

            // 递归计算p1 ~ p7
            int [][] P1 = strassenMultiply(add(A11, A22), add(B11, B22));
            int [][] P2 = strassenMultiply(add(A21, A22), B11);
            int [][] P3 = strassenMultiply(A11, sub(B12, B22));
            int [][] P4 = strassenMultiply(A22, sub(B21, B11));
            int [][] P5 = strassenMultiply(add(A11, A12), B22);
            int [][] P6 = strassenMultiply(sub(A21, A11), add(B11, B12));
            int [][] P7 = strassenMultiply(sub(A12, A22), add(B21, B22));

            // 计算子矩阵
            int [][] C11 = add(sub(add(P1, P4), P5), P7);
            int [][] C12 = add(P3, P5);
            int [][] C21 = add(P2, P4);
            int [][] C22 = add(sub(add(P1, P3), P2), P6);

            // 赋值
            copy(C11, result, 0 , 0);
            copy(C12, result, 0 , n/2);
            copy(C21, result, n/2, 0);
            copy(C22, result, n/2, n/2);
        }

        return result;
    }

    private static int[][] divide(int[][] source, int rowIndex, int columnIndex) {
        int[][] result = new int[source.length / 2][source.length / 2];

        for (int i1 = 0, i2 = rowIndex; i1 < result.length; i1++, i2++) {
            for (int j1 = 0, j2 = columnIndex; j1 < result.length; j1++, j2++) {
                result[i1][j1] = source[i2][j2];
            }
        }

        return result;
    }

    private static void copy(int[][] source, int[][] target, int rowIndex, int columnIndex) {
        for (int i1 = 0, i2 = rowIndex; i1 < source.length; i1++, i2++) {
            for (int j1 = 0, j2 = columnIndex; j1 < source.length; j1++, j2++) {
                target[i2][j2] = source[i1][j1];
            }
        }
    }

    private static int[][] sub(int[][] a, int[][] b) {
        int n = a.length;

        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = a[i][j] - b[i][j];
            }
        }

        return result;
    }

    private static int[][] add(int[][] a, int[][] b) {
        int n = a.length;

        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }

        return result;
    }
}
