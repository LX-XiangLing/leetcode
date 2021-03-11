package sort;

/**
 * @Author lixiang
 * @Date 2021/3/11
 */
public class SelectedSort {
    public static void selectedSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (i != min) {
                SwapUtil.swap(arr, i, min);
            }
        }
    }

}
