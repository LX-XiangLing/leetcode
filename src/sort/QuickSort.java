package sort;

/**
 * @Author lixiang
 * @Date 2021/3/11
 */
public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int left = low;
        int right = high;
        int key = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= key) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= key) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = key;
        quickSort(arr, low, left - 1);
        quickSort(arr, right + 1, high);
    }

    public static void main(String[] args) {
        int[] arr={2,3,6,8,3,5,6};
        quickSort(arr,0,arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
