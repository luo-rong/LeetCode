package _034_SearchRange;

public class SearchRange {
    private int[] nums;
    private int target;

    private boolean isRightIndex(int index, boolean position) {
        boolean isFirst = position && (index == 0 || nums[index - 1] < nums[index]);
        boolean isLast = !position && (index == nums.length - 1 || nums[index] < nums[index + 1]);
        return isFirst || isLast;
    }

    // position 第一个位置为true，最后一个位置为false
    private int getIndex(int l, int r, boolean position) {
        while (l <= r) {
            int mid;
            if (nums[mid = l + ((r - l) >> 1)] == target) {
                if (isRightIndex(mid, position)) {
                    return mid;
                } else {
                    l = position ? l : mid + 1;
                    r = position ? mid - 1 : r;
                }
            } else {
                r = nums[mid] > target ? mid - 1 : r;
                l = nums[mid] > target ? l : mid + 1;
            }
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        this.nums = nums;
        this.target = target;
        int l = 0;
        int r = nums.length - 1;
        int mid = l;
        while (l <= r && nums[mid = l + ((r - l >> 1))] != target) {
            r = nums[mid] > target ? mid - 1 : r;
            l = nums[mid] > target ? l : mid + 1;
        }
        int firstIndex = nums[mid] != target ? -1 : getIndex(l, mid, true);
        int lastIndex = nums[mid] != target ? -1 : getIndex(mid, r, false);
        return new int[]{firstIndex, lastIndex};
    }
}
