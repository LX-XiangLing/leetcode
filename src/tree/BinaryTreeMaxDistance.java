package tree;

/**
 * @Author lixiang
 * @Date 2021/3/18
 */
public class BinaryTreeMaxDistance {
    /**
     * 1. 最长距离不路过root，
     * 2. 最长距离路过root
     * @param root
     * @return
     */
    public static int maxDistance(TreeNode root){
        if (root == null){
            return 0 ;
        }
        //每个节点的最大距离分为上述的两种情况
        //这里需要重复的计算节点的高度
        return Math.max(height(root.left)+height(root.right)+1 ,
                Math.max(maxDistance(root.left) , maxDistance(root.right))) ;
    }

    public static int height(TreeNode root){
        if (root == null){
            return 0 ;
        }
        if (root.left == null && root.right == null){
            return 1 ;
        }
        return Math.max(height(root.left) , height(root.right))+1 ;
    }
}
