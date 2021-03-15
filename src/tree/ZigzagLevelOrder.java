package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author lixiang
 * @Date 2021/3/15
 */
public class ZigzagLevelOrder {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder (TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root!=null){
            queue.add(root);
        }
        while(!queue.isEmpty()){
            ArrayList<Integer> tmp = new ArrayList<>();     //存储每一层节点
            for(int i= queue.size();i>0;i--){               //遍历当前层的节点
                TreeNode node = queue.poll();               //弹出队列中的节点

                if((res.size()+1)%2!=0){     //res.size()+1：当前的层数，从1开始
                    tmp.add(node.val);       // 奇数层 -> 尾插
                }else{
                    tmp.add(0,node.val);     // 偶数层 -> 头插
                }

                if(node.left!=null){         //如果左子节点不为空，则将其加入到队列中
                    queue.add(node.left);
                }
                if(node.right!=null){         //如果左子节点不为空，则将其加入到队列中
                    queue.add(node.right);
                }
            }
            res.add(tmp);               //将这一层的节点加入到res中
        }
        return res;
    }
}
