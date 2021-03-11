package sort;

/**
 * @Author lixiang
 * @Date 2021/3/11
 */
public class InsertionSort {
    public static void insertionSort(int[] arr){
        for(int i=1; i<arr.length; i++){
            //比较的数
            int temp = arr[i];
            int j;
            //将当前数与前面已排序的数比较
            for(j=i; j>0&&arr[j-1]>temp; j-- ){
                arr[j] = arr[j-1];
            }
            arr[j] = temp;
        }
    }
}
