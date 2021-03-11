package sort;

import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author lixiang
 * @Date 2021/3/11
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        //需要进行length-1次冒泡
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    SwapUtil.swap(arr, j, j + 1);
                }
            }
        }
    }
}
