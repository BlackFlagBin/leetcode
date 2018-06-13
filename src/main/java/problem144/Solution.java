package problem144;

import java.util.ArrayList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 * <p>
 * 给定一个二叉树，返回它的 前序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> partList = new ArrayList<>();
        if (root != null) {
            partList.add(root.val);
            partList.addAll(preorderTraversal(root.left));
            partList.addAll(preorderTraversal(root.right));
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