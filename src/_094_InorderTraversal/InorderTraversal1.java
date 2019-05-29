package _094_InorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal1 {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> treeNodeStack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        TreeNode node = root;
        while (node != null) {
            while (node != null) {
                treeNodeStack.push(node);
                node = node.left;
            }
            while (treeNodeStack.size() > 0 && (node = treeNodeStack.pop()).right == null) {
                result.add(node.val);
            }
            // node不可能为null
            if (node.right != null) {
                result.add(node.val);
            }
            node = node.right;
        }
        return result;
    }
}
