package sort;

import java.util.Arrays;

/**
 * @Author lixiang
 * @Date 2021/3/11
 */
public class MergeSort {
    public static int[] mergeSort(int[] arr){
    if (arr.length<2){
        return arr;
    }
    int mid=arr.length/2;
    int[] left= Arrays.copyOfRange(arr,0,mid);
    int[] right= Arrays.copyOfRange(arr,mid,arr.length);
    return merge(mergeSort(left),mergeSort(right));
    }
   public static int[] merge(int[] left,int[] right){
        int[] newArr=new int[left.length+right.length];
        int i=0;
        while (left.length>0&&right.length>0){
            if (left[0]>=right[0]){
                newArr[i++]=right[0];
                right=Arrays.copyOfRange(right,1,right.length);
            }else {
                newArr[i++]=left[0];
                left=Arrays.copyOfRange(left,1,left.length);
            }
        }
        while (left.length>0){
            newArr[i++]=left[0];
            left=Arrays.copyOfRange(left,1,left.length);
        }
        while (right.length>0){
            newArr[i++]=right[0];
            right=Arrays.copyOfRange(right,1,right.length);
        }
        return newArr;
   }

    public static void main(String[] args) {
        int[] cs={2,5,4,7,9,5,1,6};
        int[] ints = mergeSort(cs);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]+" ");
        }
    }
}
