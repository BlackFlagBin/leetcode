package problem145;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
    //递归解法
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> partList = new ArrayList<>();
        if (root != null) {
            partList.addAll(postorderTraversal(root.left));
            partList.addAll(postorderTraversal(root.right));
            partList.add(root.val);
        }

        return partList;
    }

    //迭代解法
    public List<Integer> postorderTraversalIterate(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        //利用指令栈进行迭代
        Stack<Command> commandStack = new Stack<>();
        commandStack.push(new Command("go", root));
        while (commandStack.size()!=0) {
            Command topCommand = commandStack.pop();
            if (topCommand.command.equals("visit")) {
                list.add(topCommand.node.val);
            } else {
                commandStack.push(new Command("visit", topCommand.node));
                if (topCommand.node.right != null) {
                    commandStack.push(new Command("go", topCommand.node.right));
                }
                if (topCommand.node.left != null) {
                    commandStack.push(new Command("go", topCommand.node.left));
                }
            }
        }
        return list;
    }

    private class Command {
        String command;
        TreeNode node;

        public Command(String command, TreeNode node) {
            this.command = command;
            this.node = node;
        }
    }

    public class TreeNode {
        int      val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }
}