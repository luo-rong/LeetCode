package _268_MissingNumber;

public class MissingNumber {
    // 方法1
    public int missingNumber1(int[] nums) {
        int missingNum = nums.length;
        for (int i = 0; i < nums.length; ++i) {
            missingNum = missingNum - nums[i] + i;
        }
        return missingNum;
    }

    // 方法2
    public int missingNumber(int[] nums) {
        int missingNum = nums.length;
        for (int i = 0; i < nums.length; ++i) {
            missingNum = missingNum ^ nums[i] ^ i;
        }
        return missingNum;
    }
}