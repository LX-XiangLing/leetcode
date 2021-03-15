package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author lixiang
 * @Date 2021/3/15
 */
public class BinaryTreeIsBSTOrIsFull {
    /**
     *
     * @param root TreeNode类 the root
     * @return bool布尔型一维数组
     */
    public boolean[] judgeIt (TreeNode root) {
        // write code here
        if (root == null) {
            return new boolean[]{true, false};
        }

        // 借助两个临时变量充当子节点值和根节点值
        boolean res1 = isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        boolean res2 = isFull(root);
        return new boolean[]{res1, res2};
    }

    public boolean isBST(TreeNode root, Integer minVal, Integer maxVal) {
        if (root == null) {
            return true;
        }
        // 若不满足 BST 的性质，返回 false
        if (root.val <= minVal || root.val >= maxVal) {
            return false;
        }
        // 左边节点值全部小于根节点值，右边全部大于根节点值
        return isBST(root.left, minVal, root.val)
                && isBST(root.right, root.val, maxVal);
    }

    public boolean isFull(TreeNode root) {
        // 若树为空，不满足完全二叉树的条件，false
        if (root == null) {
            return false;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        /*
            算法思路：1. 若左右节点均不为空，将该节点chuduilie
                     2. 若左节点为空，但右节点不为空，false
                     3. 若右节点为空，如左节点不为空，则将该节点添入队列，并将当前节点弹出队列
                     4. 若右节点为空，则之后的节点都必须为叶子节点，才可满足完全二叉树的条件，判断队列是否为空，若非空，咋判断每个节点是否为叶子节点，不满足为 false
                     5. 所有元素出队列后需跳出循环，不然会进入死循环
        */
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i ++) {
                TreeNode tt = q.peek();
                if (tt.left != null && tt.right != null) {
                    q.poll();
                    q.offer(tt.left);
                    q.offer(tt.right);
                }
                else if (tt.left == null && tt.right != null) {
                    return false;
                }
                else if (tt.right == null && (tt.left == null || tt.left != null)) {
                    if (tt.left != null) {
                        q.offer(tt.left);
                    }
                    q.poll();
                    while (!q.isEmpty()) {
                        TreeNode t = q.poll();
                        if (t.left != null || t.right != null) {
                            return false;
                        }
                    }
                    break;
                }
            }
        }
        return true;
    }
}
