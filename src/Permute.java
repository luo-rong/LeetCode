import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Permute {
    private HashMap<Integer, Integer> numsHashMap;
    private List<Integer> list;
    private List<List<Integer>> result;
    private int[] nums;

    private void permuteNums(int x) {
        if (x == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (numsHashMap.get(i) == null) {
                numsHashMap.put(i, nums[i]);
                list.add(nums[i]);
                permuteNums(x + 1);
                numsHashMap.remove(i);
                list.remove(x);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        this.list = new ArrayList<>();
        this.result = new ArrayList<>();
        this.numsHashMap = new HashMap<>();
        permuteNums(0);
        return result;
    }

    public static void main(String[] args) {
        Permute permute = new Permute();
        List<List<Integer>> result = permute.permute(new int[]{1, 2, 3});
        for (List<Integer> list : result) {
            for (Integer num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
