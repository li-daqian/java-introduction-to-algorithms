package subarray;

/**
 * @author LiDaQian
 */
public class FindMaximumSubArray {

    /**
     * 找到最大子数组
     * 时间复杂度 O(n*lgn)
     * @param array
     * @return
     */
    public static SubArray find(int[] array) {
        return find(array, 0, array.length - 1);
    }

    private static SubArray find(int[] array, int low, int high) {
        if (low == high) {
            return new SubArray(low, high, array[low]);
        }

        int mid = (low + high) / 2;
        // 左半部分最大子数组
        SubArray leftSubArray = find(array, low, mid);
        // 右半部分最大子数组
        SubArray rightSubArray = find(array, mid + 1, high);
        // 跨中点最大子数组
        SubArray crossSubArray = findByCrossing(array, low, mid, high);

        // 从三者子数组中找到最大的
        if (leftSubArray.getSum() >= rightSubArray.getSum() && leftSubArray.getSum() >= crossSubArray.getSum()) {
            return leftSubArray;
        } else if (rightSubArray.getSum() >= leftSubArray.getSum() && rightSubArray.getSum() >= crossSubArray.getSum()) {
            return rightSubArray;
        } else {
            return crossSubArray;
        }

    }

    private static SubArray findByCrossing(int[] array, int low, int mid, int high) {
        // 求左部分最大子数组
        int leftMaxSum = Integer.MIN_VALUE;
        int leftSum = 0;
        int leftIndex = 0;
        for (int i = mid; i >= low; i--) {
            leftSum += array[i];
            if (leftSum > leftMaxSum) {
                leftMaxSum = leftSum;
                leftIndex = i;
            }
        }

        // 求右部分最大子数组
        int rightMaxSum = Integer.MIN_VALUE;
        int rightSum = 0;
        int rightIndex = 0;
        for (int i = mid + 1; i < high + 1; i++) {
            rightSum += array[i];
            if (rightSum > rightMaxSum) {
                rightMaxSum = rightSum;
                rightIndex = i;
            }
        }

        // 合并 返回
        return new SubArray(leftIndex, rightIndex, leftMaxSum + rightMaxSum);
    }
}
