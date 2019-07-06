package _198_HouseRobber;

public class HouseRobber {
    public int rob(int[] nums) {
        int sumEven = 0, sumOdd = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i % 2 == 0) {
                sumOdd += nums[i];
                sumOdd = Math.max(sumEven, sumOdd);
            } else {
                sumEven += nums[i];
                sumEven = Math.max(sumEven, sumOdd);
            }
        }
        return Math.max(sumEven, sumOdd);
    }
}