package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * <p>
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * <p>
 * 输入：root = []
 * 输出：[]
 * <p>
 * 输入：root = [1]
 * 输出：[1]
 * <p>
 * 输入：root = [1,2]
 * 输出：[2,1]
 *
 * @Author lixiang
 * @Date 2020/12/26
 */
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        dfs(result, root);
        return result;
    }

    private void dfs(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(result, root.left);
        result.add(root.val);
        dfs(result, root.right);
    }

}
