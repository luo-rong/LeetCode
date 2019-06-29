package _094_BinaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> treeNodeStack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        TreeNode node = root;
        while (node != null || !treeNodeStack.isEmpty()) {
            while (node != null) {
                treeNodeStack.push(node);
                node = node.left;
            }
            if (!treeNodeStack.isEmpty()) {
                node = treeNodeStack.pop();
                result.add(node.val);
                node = node.right;
            }
        }
        return result;
    }
}
