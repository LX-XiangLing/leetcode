package tree;

import java.util.HashMap;

/**
 * @Author lixiang
 * @Date 2021/2/18
 */
public class HouseRobberIII {
    public int rob(TreeNode root) {
        HashMap<TreeNode, Integer> treeNodeIntegerHashMap = new HashMap<>();
        int robs = robs(root, treeNodeIntegerHashMap);
        return robs;
    }

    public int robs(TreeNode root, HashMap<TreeNode, Integer> map) {
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }
        int money = root.val;
        if (root.left != null) {
            money += (robs(root.left.left, map) + robs(root.left.right, map));
        }
        if (root.right != null) {
            money += (robs(root.right.left, map) + robs(root.right.right, map));
        }
        int max = Math.max(money, robs(root.right, map) + robs(root.left, map));
        map.put(root, max);
        return max;
    }
}
