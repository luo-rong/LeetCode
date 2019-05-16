public class MaxPathSum {
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int result;

    private int max(int... nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = num > max ? num : max;
        }
        return max;
    }

    private int getSum(TreeNode node) {
        if (node == null) return 0;
        int leftSum = getSum(node.left);
        int rightSum = getSum(node.right);
        int maxSum = max(leftSum + node.val, rightSum + node.val, node.val);
        result = max(result, maxSum, leftSum + rightSum + node.val);
        return maxSum;
    }


    public int maxPathSum(TreeNode root) {
        this.result = Integer.MIN_VALUE;
        getSum(root);
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left.right = new TreeNode(1);
        MaxPathSum maxPathSum = new MaxPathSum();
        System.out.println(maxPathSum.maxPathSum(root));
    }
}
