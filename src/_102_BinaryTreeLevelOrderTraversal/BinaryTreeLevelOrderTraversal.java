package _102_BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> parentNodes = new LinkedList<>(), childrenNodes = new LinkedList<>();
        List<List<Integer>> levelOrderList = new ArrayList<>();
        parentNodes.add(root);
        while (parentNodes.size() != 0) {
            List<Integer> levelList = new ArrayList<>();
            while (parentNodes.size() != 0) {
                TreeNode node = parentNodes.poll();
                levelList.add(node.val);
                if (node.left != null) {
                    childrenNodes.add(node.left);
                }
                if (node.right != null) {
                    childrenNodes.add(node.right);
                }
            }
            levelOrderList.add(levelList);
            Queue<TreeNode> temp = parentNodes;
            parentNodes = childrenNodes;
            childrenNodes = temp;
        }
        return levelOrderList;
    }
}
