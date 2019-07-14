package BiweeklyContest.BiweeklyContest4;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class MaximumAverageSubtree {
    class NodeSum {
        int count;
        int sum;

        NodeSum(int count, int sum) {
            this.count = count;
            this.sum = sum;
        }
    }

    private double maximumAverage;

    private NodeSum calculateNode(TreeNode node) {
        if (node == null) {
            return new NodeSum(0, 0);
        }
        NodeSum left = calculateNode(node.left), right = calculateNode(node.right);
        int count = left.count + right.count + 1;
        int sum = left.sum + right.sum + node.val;
        maximumAverage = Math.max(maximumAverage, (double) sum / count);
        return new NodeSum(count, sum);
    }

    public double maximumAverageSubtree(TreeNode root) {
        maximumAverage = 0;
        calculateNode(root);
        return maximumAverage;
    }
}
