package Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author lixiang
 * @Date 2021/3/30
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            if (!set.add(x)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate1(int[] nums) {
        return Arrays.stream(nums).distinct().count() < nums.length;
    }

}
