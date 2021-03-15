package search;

/**
 * @Author lixiang
 * @Date 2021/3/15
 */
public class BinarySearchToLeft {
    public int search (int[] nums, int target) {
        // write code here
        int left = 0, right = nums.length - 1;
        int idx = -1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                idx = mid;
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return idx;
    }
}
