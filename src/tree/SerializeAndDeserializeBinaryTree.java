package tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author lixiang
 * @Date 2021/2/18
 */
public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return aserialize(root, "");
    }

    public String aserialize(TreeNode root, String str) {
        if (root == null) {
            str += "None,";
        } else {
            str += String.valueOf(root.val) + ",";
            str = aserialize(root.left, str);
            str = aserialize(root.right, str);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        List<String> strings = new LinkedList<>(Arrays.asList(split));
        return adeserialize(strings);
    }

    public TreeNode adeserialize(List<String> list) {
        if (list.get(0).equals("None")) {
            list.remove(0);
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        treeNode.left = adeserialize(list);
        treeNode.right = adeserialize(list);
        return treeNode;
    }




}
