package util;

import java.util.Random;

/**
 * @author LiDaQian
 */
public class ArrayUtil {

    private static final Random RANDOM = new Random();

    public static int[] generateRandomArray(int length) {
        int[] randomArray = new int[length];
        for (int i = 0; i < length; i++) {
            int num = RANDOM.nextInt(100);
            randomArray[i] = num;
        }

        return randomArray;
    }
}
