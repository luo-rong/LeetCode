package _448_FindAllNumbersDisappearedInAnArray;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            nums[(nums[i] - 1) % nums.length] += nums.length;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] <= nums.length) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
