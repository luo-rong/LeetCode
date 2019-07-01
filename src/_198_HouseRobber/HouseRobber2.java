package _198_HouseRobber;

public class HouseRobber2 {
    public int rob(int[] nums) {
        if (nums.length <= 1) {
            return nums.length == 0 ? 0 : nums[0];
        }
        int[] robNums = new int[nums.length];
        robNums[0] = nums[0];
        robNums[1] = Math.max(robNums[0], nums[1]);
        for (int i = 2; i < nums.length; ++i) {
            robNums[i] = Math.max(robNums[i - 1], robNums[i - 2] + nums[i]);
        }
        return robNums[nums.length - 1];
    }
}