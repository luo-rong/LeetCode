package _108_SortedArrayToBST;

public class SortedArrayToBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int middle = nums.length >> 1;
        int[] nums1 = new int[middle];
        int[] nums2 = new int[nums.length - middle - 1];
        System.arraycopy(nums, 0, nums1, 0, nums1.length);
        System.arraycopy(nums, middle + 1, nums2, 0, nums2.length);
        TreeNode boot = new TreeNode(nums[middle]);
        boot.left = sortedArrayToBST(nums1);
        boot.right = sortedArrayToBST(nums2);
        return boot;
    }
}
