package tree;

/**
 * @Author lixiang
 * @Date 2021/3/15
 */
public class ImageOfBinaryTree {
    public TreeNode Mirror (TreeNode pRoot) {
        // write code here
        if(pRoot == null) {
            return pRoot;
        }
        TreeNode temp= pRoot.left;
        pRoot.left = pRoot.right;
        pRoot.right = temp;
        Mirror(pRoot.left);
        Mirror(pRoot.right);
        return pRoot;
    }
}
