package tree;

/**
 * @Author lixiang
 * @Date 2021/2/13
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode node = root.right;
        root.right = root.left;
        root.left = node;
        invertTree(root.right);
        invertTree(root.left);
        return root;
    }
}
