package _287_FindTheDuplicateNumber;

public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        if (nums.length <= 1) {
            return -1;
        }
        // 共同起点是0
        int fast = nums[nums[0]];
        int slow = nums[0];
        // 第一次相遇
        while (fast != slow) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        // 寻找入环点
        slow = 0;
        while (fast != slow) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}
