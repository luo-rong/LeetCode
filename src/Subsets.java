import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        int tot = (int) Math.pow(2, nums.length);
        Set<List<Integer>> result = new HashSet<>();
        List<Integer> list;
        for (int i = 0; i < tot; ++i) {
            list = new ArrayList<>();
            for (int j = 0; j < nums.length; ++j) {
                if (((i >> j) & 1) != 0) {
                    list.add(nums[j]);
                }
            }
            result.add(list);
        }
        return new ArrayList<>(result);
    }
}