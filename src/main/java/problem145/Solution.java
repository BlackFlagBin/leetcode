package problem145;

import java.util.ArrayList;
import java.util.List;

/**
 * 145. 二叉树的后序遍历
 * <p>
 * 给定一个二叉树，返回它的 后序 遍历。
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
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> partList = new ArrayList<>();
        if (root != null) {
            partList.addAll(postorderTraversal(root.left));
            partList.addAll(postorderTraversal(root.right));
            partList.add(root.val);
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