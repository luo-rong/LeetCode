package _103_BinaryTreeZigzagLevelOrderTraversal;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> parentNodes = new Stack<>(), childNodes = new Stack<>();
        if (root != null) {
            parentNodes.push(root);
        }
        int depthMark = 0;
        List<List<Integer>> zigzagLevelOrder = new ArrayList<>();
        while (!parentNodes.isEmpty()) {
            List<Integer> levelOrder = new ArrayList<>();
            while (!parentNodes.isEmpty()) {
                TreeNode node = parentNodes.pop();
                levelOrder.add(node.val);
                if (depthMark == 0) {
                    if (node.left != null) {
                        childNodes.push(node.left);
                    }
                    if (node.right != null) {
                        childNodes.push(node.right);
                    }
                } else {
                    if (node.right != null) {
                        childNodes.push(node.right);
                    }
                    if (node.left != null) {
                        childNodes.push(node.left);
                    }
                }
            }
            parentNodes = childNodes;
            childNodes = new Stack<>();
            depthMark = 1 - depthMark;
            zigzagLevelOrder.add(levelOrder);
        }
        return zigzagLevelOrder;
    }
}
