package _108_SortedArrayToBST;

public class SortedArrayToBST_2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int[] nums;

    private TreeNode buildTree(int l, int r) {
        if (r < l) {
            return null;
        }
        int mid = l + ((r - l) >> 1);
        TreeNode boot = new TreeNode(nums[mid]);
        boot.left = buildTree(l, mid - 1);
        boot.right = buildTree(mid + 1, r);
        return boot;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return buildTree(0, nums.length - 1);
    }
}
