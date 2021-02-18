package tree;

/**
 * 二叉树的直径
 *
 * @Author lixiang
 * @Date 2021/2/18
 */
public class DiameterOfBinaryTree {
    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        max(root);
        return res;
    }

    /**
     * 算出树最大深度
     * @param node
     * @return
     */
    public int max(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftMax = max(node.left);
        int rightMax = max(node.right);
        res = Math.max(res, leftMax + rightMax);
        return Math.max(leftMax, rightMax) + 1;
    }
}
