package subarray;

import java.util.Objects;

/**
 * @author LiDaQian
 */
public class SubArray {

    private int leftIndex;
    private int rightIndex;
    private int sum;

    public SubArray(int leftIndex, int rightIndex, int sum) {
        this.leftIndex = leftIndex;
        this.rightIndex = rightIndex;
        this.sum = sum;
    }

    public int getLeftIndex() {
        return leftIndex;
    }

    public void setLeftIndex(int leftIndex) {
        this.leftIndex = leftIndex;
    }

    public int getRightIndex() {
        return rightIndex;
    }

    public void setRightIndex(int rightIndex) {
        this.rightIndex = rightIndex;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubArray subArray = (SubArray) o;
        return leftIndex == subArray.leftIndex &&
                rightIndex == subArray.rightIndex &&
                sum == subArray.sum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftIndex, rightIndex, sum);
    }

    @Override
    public String toString() {
        return "SubArray{" +
                "leftIndex=" + leftIndex +
                ", rightIndex=" + rightIndex +
                ", sum=" + sum +
                '}';
    }
}
