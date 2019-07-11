package _075_SortColors;

public class SortColors {
    public void sortColors(int[] nums) {
        int i = 0, j = nums.length - 1;
        int x = i, y = j;
        while (i < j) {
            while (i < j && nums[i] == 0) {
                i++;
                nums[x++] = 0;
            }
            while (i < j && nums[j] == 2) {
                j--;
                nums[y--] = 2;
            }
            if (nums[i] == 1 || nums[j] == 1) {
                if (nums[j] == 1) {
                    --j;
                } else {
                    ++i;
                }
            } else {
                if (nums[i] == 2) {
                    nums[x++] = 0;
                    ++i;
                }
                if (nums[j] == 0) {
                    nums[y--] = 2;
                    --j;
                }
            }
        }
        for (int k = x; k < y; ++k) {
            nums[k] = 1;
        }
    }
}
