package _189_RotateArray;

public class RotateArray {
    // 空间复杂度O(1)
    public void rotate1(int[] nums, int k) {
        if (nums.length <= 1) {
            return;
        }
        for (int i = 0; i < k; ++i) {
            int lastNum = nums[nums.length - 1];
            System.arraycopy(nums, 0, nums, 1, nums.length - 1);
            nums[0] = lastNum;
        }
    }

    // 空间复杂度O(n)
    public void rotate2(int[] nums, int k) {
        int[] numsCopy = new int[nums.length];
        System.arraycopy(nums, 0, numsCopy, 0, nums.length);
        for (int i = 0; i < nums.length; ++i) {
            int index = i - k;
            while (index < 0) {
                index += nums.length;
            }
            nums[i] = numsCopy[index];
        }
    }
}
