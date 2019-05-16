import java.util.ArrayList;

public class LowestCommonAncestor2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private ArrayList<TreeNode> pathP, pathQ;
    private TreeNode p, q;

    private void dfs(TreeNode node, ArrayList<TreeNode> path) {
        if (node == null || (pathP.size() != 0 && pathQ.size() != 0)) {
            return;
        }
        path.add(node);
        if (node.equals(p)) {
            pathP = new ArrayList<>(path);
        } else if (node.equals(q)) {
            pathQ = new ArrayList<>(path);
        }
        dfs(node.left, path);
        dfs(node.right, path);
        path.remove(path.size() - 1);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        pathP = new ArrayList<>();
        pathQ = new ArrayList<>();
        this.p = p;
        this.q = q;
        dfs(root, new ArrayList<>());
        int i = Math.min(pathP.size(), pathQ.size()) - 1;
        while (i > 0 && !pathP.get(i).equals(pathQ.get(i))) {
            --i;
        }
        return i < 0 ? null : pathP.get(i);
    }
}
