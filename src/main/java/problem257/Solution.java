package problem257;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 * <p>
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * <p>
 * 输出: ["1->2->5", "1->3"]
 * <p>
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 * <p>
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        if (root.left == null && root.right == null) {
            list.add(Integer.toString(root.val));
        }

        List<String> leftList = binaryTreePaths(root.left);
        for (int i = 0; i < leftList.size(); i++) {
            list.add(Integer.toString(root.val) + "->" + leftList.get(i));
        }
        List<String> rightList = binaryTreePaths(root.right);
        for (int i = 0; i < rightList.size(); i++) {
            list.add(Integer.toString(root.val) + "->" + rightList.get(i));
        }


        return list;
    }

    public class TreeNode {
        int      val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }
}