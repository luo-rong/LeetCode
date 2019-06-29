package _283_MoveZeroes;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }
        for (; index < nums.length; ++index) {
            nums[index] = 0;
        }
    }
}
