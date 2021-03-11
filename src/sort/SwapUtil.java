package sort;

/**
 * @Author lixiang
 * @Date 2021/3/11
 */
public class SwapUtil {

    public static void swap(int[] arr, int i, int j) {
        int t;
        t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
