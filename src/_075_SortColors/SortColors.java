package _075_SortColors;

public class SortColors {
    public void sortColors(int[] nums) {
        int l = 0, r = nums.length-1;
        for (int curr = 0; curr <= r; ) {
            switch (nums[curr]) {
                case 0:
                    nums[curr++]=nums[l];
                    nums[l++] = 0;
                    break;
                case 1:
                    ++curr;
                    break;
                case 2:
                    nums[curr] = nums[r];
                    nums[r--] = 2;
                    break;
                default:
            }
        }
    }
}
