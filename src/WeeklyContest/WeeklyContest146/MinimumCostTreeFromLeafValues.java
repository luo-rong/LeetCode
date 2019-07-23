package WeeklyContest.WeeklyContest146;

import java.util.ArrayList;
import java.util.List;

public class MinimumCostTreeFromLeafValues {
    List<Integer> leaves;

    private int mergeTwoMinLeaves() {
        int index = 0;
        int minProduct = Integer.MAX_VALUE;
        for (int i = 1; i < leaves.size(); ++i) {
            if (leaves.get(i - 1) * leaves.get(i) < minProduct) {
                minProduct = leaves.get(i - 1) * leaves.get(i);
                index = i;
            }
        }
        leaves.set(index, Math.max(leaves.get(index - 1), leaves.get(index)));
        leaves.remove(index - 1);
        return minProduct;
    }

    public int mctFromLeafValues(int[] arr) {
        leaves = new ArrayList<>(arr.length);
        for (int leaf : arr) {
            leaves.add(leaf);
        }
        int mctFromLeafValues = 0;
        while (leaves.size() > 1) {
            mctFromLeafValues += mergeTwoMinLeaves();
        }
        return mctFromLeafValues;
    }
}
