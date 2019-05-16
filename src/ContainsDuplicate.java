import java.util.HashSet;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> numHashSet = new HashSet<>();
        for (int num : nums) {
            if (numHashSet.contains(num)) {
                return true;
            }
            numHashSet.add(num);
        }
        return false;
    }
}
