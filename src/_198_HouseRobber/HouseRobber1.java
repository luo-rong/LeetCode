package _198_HouseRobber;

public class HouseRobber1 {
    private int[] nums;
    private int[][] robNums;

    private int robNums(int x, int y) {
        if (x < 0) {
            return 0;
        }
        if (robNums[x][y] == -1) {
            robNums[x][y] = y - x > 1 ? Math.max(robNums(x - 1, y), robNums(x - 1, x) + nums[x]) : robNums(x - 1, y);
        }
        return robNums[x][y];
    }

    public int rob(int[] nums) {
        this.nums = nums;
        this.robNums = new int[nums.length][nums.length + 2];
        for (int i = 0; i < nums.length; ++i) {
            for (int j = 0; j < nums.length + 2; ++j) {
                robNums[i][j] = -1;
            }
        }
        return robNums(nums.length - 1, nums.length + 1);
    }
}