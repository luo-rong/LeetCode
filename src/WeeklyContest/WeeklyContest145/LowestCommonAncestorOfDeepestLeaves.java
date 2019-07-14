package WeeklyContest.WeeklyContest145;

import java.util.ArrayDeque;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


public class LowestCommonAncestorOfDeepestLeaves {
    class Node {
        int val;
        Node left;
        Node right;
        TreeNode treeNode;

        Node(int val, TreeNode treeNode) {
            this.val = val;
            this.treeNode = treeNode;
        }
    }

    private Node dfs(TreeNode node, int depth) {
        if (node == null) {
            return new Node(0, null);
        }
        Node left = dfs(node.left, depth + 1);
        Node right = dfs(node.right, depth + 1);
        Node newNode = new Node(Math.max(depth, Math.max(left.val, right.val)), node);
        newNode.left = left.val == 0 ? null : left;
        newNode.right = right.val == 0 ? null : right;
        return newNode;
    }

    private TreeNode lowestCommonAncestor(Node root) {
        Queue<Node> parent = new ArrayDeque<>(), chile = new ArrayDeque<>();
        parent.add(root);
        TreeNode ancestor = root.treeNode, lowestAncestor = root.treeNode;
        int maxDepth = 0, maxCount = 1;
        while (!parent.isEmpty()) {
            while (!parent.isEmpty()) {
                Node node = parent.poll();
                if (node.val > maxDepth) {
                    maxDepth = node.val;
                    maxCount = 1;
                    ancestor = node.treeNode;
                } else if (node.val == maxDepth) {
                    maxCount++;
                }
                if (node.left != null) {
                    chile.add(node.left);
                }
                if (node.right != null) {
                    chile.add(node.right);
                }
            }
            if (maxCount == 1) {
                lowestAncestor = ancestor;
            } else {
                break;
            }
            maxDepth = 0;
            maxCount = 0;
            Queue<Node> temp = parent;
            parent = chile;
            chile = temp;
        }
        return lowestAncestor;
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Node depthTreeRoot = dfs(root, 0);
        return lowestCommonAncestor(depthTreeRoot);
    }
}
