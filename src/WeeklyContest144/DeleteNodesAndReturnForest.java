package WeeklyContest144;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class DeleteNodesAndReturnForest {
    private List<TreeNode> forest;
    private int[] toDelete;

    private boolean isToDelete(TreeNode node) {
        if (node != null) {
            for (int val : toDelete) {
                if (val == node.val) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean delTreeNodes(TreeNode node) {
        if (node == null) {
            return false;
        }
        if (delTreeNodes(node.left)) {
            node.left = null;
        }
        if (delTreeNodes(node.right)) {
            node.right = null;
        }
        if (isToDelete(node)) {
            if (node.left != null) {
                forest.add(node.left);
            }
            if (node.right != null) {
                forest.add(node.right);
            }
            return true;
        }
        return false;
    }


    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        this.toDelete = to_delete;
        this.forest = new ArrayList<>();
        if (!isToDelete(root)) {
            forest.add(root);
        }
        delTreeNodes(root);
        return forest;
    }
}
