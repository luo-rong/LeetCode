import java.util.ArrayList;
import java.util.List;

public class KthSmallest {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private List<TreeNode> nodeList;
    private int k;

    // 中序遍历
    private void dfs(TreeNode node) {
        if (node == null || nodeList.size() >= k) {
            return;
        }
        dfs(node.left);
        nodeList.add(node);
        dfs(node.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        nodeList = new ArrayList<>();
        this.k = k;
        dfs(root);
        return nodeList.get(k - 1).val;
    }
}
