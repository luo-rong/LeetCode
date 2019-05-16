import java.util.HashMap;

public class MajorityElement {
    public int majorityElement1(int[] nums) {
        HashMap<Integer, Integer> numsHashMap = new HashMap<>();
        for (int num : nums) {
            if (numsHashMap.get(num) == null) {
                numsHashMap.put(num, 1);
            } else {
                numsHashMap.put(num, numsHashMap.get(num) + 1);
            }
        }
        for (int key : numsHashMap.keySet()) {
            if (numsHashMap.get(key) > nums.length / 2) {
                return key;
            }
        }
        return 0;
    }

    public int majorityElement(int[] nums) {
        int count = 0;
        int result = nums[0];
        for (int num : nums) {
            if (count == 0) result = num;
            count = num == result ? ++count : --count;
        }
        return result;
    }
}
