package tree;

import java.util.*;

/**
 * @Author lixiang
 * @Date 2021/3/31
 */
public class MostFrequentSubtreeSum {
    private int maxcount = 1;//记录子树元素的最大重复个数
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> hash = new HashMap<>();//记录子树元素和，以及出现的频数
        getSumAndCount(root, hash);
        int l = 0;
        Set Keys = hash.keySet();
        List<Integer> list = new ArrayList<>();
        for (Object k : Keys) {         //遍历hashmap
            if (hash.get(k) == maxcount) {
                list.add((int) k);
            }
        }
        int[] ans = new int[list.size()];
        while (l < list.size()) {
            ans[l] = list.get(l++);
        }
        return ans;
    }

    private int getSumAndCount(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        int l_sum = getSumAndCount(root.left, map);//求当前节点的左子树的"子树元素和"
        int r_sum = getSumAndCount(root.right, map);//求当前节点的右子树的"子树元素和"
        int ret = root.val + l_sum + r_sum;//该节点的子树元素和（也是返回值）
        if (map.containsKey(ret)) {//如果hashmap中包含这个"子树元素和"的值
            int temp = map.get(ret) + 1;
            map.put(ret, temp);//更新hashmap中的键值对
            if (maxcount < temp) {
                maxcount = temp;
            }//比较并更新“子树数元素和”的最大重复个数
        } else {
            map.put(ret, 1);
        }//如果不存在，直接存入即可
        return ret;
    }

}
