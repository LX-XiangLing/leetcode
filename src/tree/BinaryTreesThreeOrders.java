package tree;

import java.util.*;

/*
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 * }
 */

public class BinaryTreesThreeOrders {
    /**
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public int[][] threeOrders(TreeNode root) {
        // write code here
        List<Integer> p = new ArrayList<>();
        pre(root, p);
        List<Integer> i = new ArrayList<>();
        in(root, i);
        List<Integer> o = new ArrayList<>();
        out(root, o);
        int size = Math.max(p.size(), Math.max(i.size(), o.size()));
        int[][] re = new int[3][size];
        int[] pint = new int[p.size()];
        for (int m = 0; m < p.size(); m++) {
            pint[m] = p.get(m);
        }
        int[] iint = new int[i.size()];
        for (int j = 0; j < i.size(); j++) {
            iint[j] = i.get(j);
        }
        int[] oint = new int[o.size()];
        for (int k = 0; k < o.size(); k++) {
            oint[k] = o.get(k);
        }
        re[0] = pint;
        re[1] = iint;
        re[2] = oint;
        return re;
    }

    public static void pre(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        pre(root.left, list);
        pre(root.right, list);
    }

    public static void in(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        in(root.left, list);
        list.add(root.val);
        in(root.right, list);
    }

    public static void out(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        out(root.left, list);
        out(root.right, list);
        list.add(root.val);
    }
}