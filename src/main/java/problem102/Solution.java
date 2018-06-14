package problem102;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 102. 二叉树的层次遍历
 * <p>
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        //利用队列进行层序遍历
        ArrayList<List<Integer>> resultList = new ArrayList<>();
        ArrayDeque<NodeLevelPair<TreeNode, Integer>> queue = new ArrayDeque<>();
        if (root == null) {
            return resultList;
        }

        queue.offer(new NodeLevelPair<>(root, 0));
        while (!queue.isEmpty()) {
            NodeLevelPair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.fst;
            Integer level = pair.snd;
            if (level == resultList.size()) {
                resultList.add(new ArrayList<>());
            }

            resultList.get(level).add(node.val);
            if (node.left != null) {
                queue.offer(new NodeLevelPair<>(node.left, level + 1));
            }
            if (node.right != null) {
                queue.offer(new NodeLevelPair<>(node.right, level + 1));
            }
        }

        return resultList;
    }

    public class NodeLevelPair<K, V> {
        K fst;
        V snd;

        NodeLevelPair(K fst, V snd) {
            this.fst = fst;
            this.snd = snd;
        }
    }

    public class TreeNode {
        int      val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }
}