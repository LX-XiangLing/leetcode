package tree;

/**
 * @Author lixiang
 * @Date 2021/2/18
 */
public class ConvertBSTToGreaterTree {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }

}
