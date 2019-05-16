import java.util.ArrayList;
import java.util.LinkedList;

public class LowestCommonAncestor {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private ArrayList<TreeNode> nodeArray = new ArrayList<>();

    private void bfs(TreeNode root) {
        LinkedList<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        int count = root == null ? 0 : 1;
        while (count != 0) {
            TreeNode node = nodeQueue.pop();
            nodeArray.add(node);
            if (node != null) {
                --count;
                nodeQueue.add(node.left);
                nodeQueue.add(node.right);
                count = node.left == null ? count : ++count;
                count = node.right == null ? count : ++count;
            } else {
                nodeQueue.add(null);
                nodeQueue.add(null);
            }
        }
    }

    private int getParentIndex(int sonIndex) {
        if ((sonIndex & 1) == 0) {
            return (sonIndex - 2) / 2;
        } else {
            return (sonIndex - 1) / 2;
        }
    }

    // 超时
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        bfs(root);
        int indexP = nodeArray.indexOf(p);
        int indexQ = nodeArray.indexOf(q);
        while (indexP != indexQ) {
            if (indexP > indexQ) {
                indexP = getParentIndex(indexP);
            } else {
                indexQ = getParentIndex(indexQ);
            }
        }
        return nodeArray.get(indexP);
    }


    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        while (node != null) {
            if (p.val < node.val && q.val < node.val) {
                node = node.left;
            } else if (p.val > node.val && q.val > node.val) {
                node = node.right;
            } else {
                break;
            }
        }
        return node;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        while (node != null) {
            if ((node.val - p.val) * (node.val - q.val) > 0) {
                node = node.val - p.val > 0 ? node.left : node.right;
            } else {
                break;
            }
        }
        return node;
    }
}
