package BiweeklyContest.BiweeklyContest4;

import java.util.Arrays;

public class DivideArrayIntoIncreasingSequences {
    public boolean canDivideIntoSubsequences(int[] nums, int K) {
        Arrays.sort(nums);
        int maxSameCount = 0, sameCount = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == nums[i - 1]) {
                sameCount++;
            } else {
                maxSameCount = Math.max(maxSameCount, sameCount);
                sameCount = 1;
            }
        }
        maxSameCount = Math.max(maxSameCount, sameCount);
        return maxSameCount <= nums.length / K;
    }
}
