package problem094;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * <p>
 * 给定一个二叉树，返回它的中序 遍历。

 示例:

 输入: [1,null,2,3]
 1
 \
 2
 /
 3

 输出: [1,3,2]
 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> partList = new ArrayList<>();
        if (root != null) {
            partList.addAll(inorderTraversal(root.left));
            partList.add(root.val);
            partList.addAll(inorderTraversal(root.right));
        }

        return partList;
    }

    public class TreeNode {
        int      val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }
}