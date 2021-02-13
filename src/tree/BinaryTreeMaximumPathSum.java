package tree;

/**
 * @Author lixiang
 * @Date 2021/2/12
 */
public class BinaryTreeMaximumPathSum {
    int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int dfs = dfs(root);

        return result;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int right = Math.max(dfs(root.right), 0);
        int left = Math.max(dfs(root.left), 0);
        result=Math.max(result, root.val+right+left);
        return root.val+Math.max(right, left);
    }
}
