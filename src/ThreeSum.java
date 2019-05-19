import java.util.*;

public class ThreeSum {
    private int[] removeDuplicate(int[] nums) {
        int[] newNums = new int[nums.length];
        int x = 0;
        int len = 0;
        while (x < nums.length) {
            int y = x + 1;
            while (y < nums.length && nums[x] == nums[y]) ++y;
            int count = 1;
            if (y - x >= 3 && nums[x] == 0) {
                count = 3;
            } else if (y - x >= 2) {
                count = 2;
            }
            for (int i = 0; i < count; ++i) {
                newNums[len++] = nums[x];
            }
            x = y;
        }
        nums = new int[len];
        for (int i = 0; i < len; ++i) {
            nums[i] = newNums[i];
        }
        return nums;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
//        nums = removeDuplicate(nums);
        HashMap<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            numMap.put(nums[i], i);
        }
        List<Integer> list;
        for (int i = 0; i < nums.length && nums[i] <= 0; ++i) {
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length && nums[i] + nums[j] <= 0; ++j) {
                Integer key = numMap.get(-nums[i] - nums[j]);
                if (key != null && key > j) {
                    list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(-nums[i] - nums[j]);
                    result.add(list);
                }
            }
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(new int[]{0, 0, 0, 0}).toString());
        System.out.println(threeSum.threeSum(new int[]{1, 1, 0, -2, -1, -1}).toString());
    }
}
