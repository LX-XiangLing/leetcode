package Array;

import java.util.Arrays;

/**
 * @Author lixiang
 * @Date 2021/3/18
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
// 先将nums1中数字拷贝出来
        int[] arr = Arrays.copyOfRange(nums1, 0, m);
        int m1 = 0;
        int n1 = 0;
        int count = 0;
        while (m1<m && n1<n){
            // 谁小，谁进新数组
            if(arr[m1] <= nums2[n1]){
                nums1[count++] = arr[m1++];
            }else {
                nums1[count++] = nums2[n1++];
            }

        }
        // 查看哪个数组没有结束
        while (m1<m){
            nums1[count++] = arr[m1++];
        }
        while (n1<n){
            nums1[count++] = nums2[n1++];
        }
    }
}
