package WeeklyContest141;

import java.util.HashMap;

public class LargestValsFromLabels {    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
    int largestVals = 0;
    HashMap<Integer, Integer> labelsHashMap = new HashMap<>();
    for (int i = 0; i < values.length && num_wanted > 0; ++i) {
        if (!labelsHashMap.containsKey(labels[i]) || labelsHashMap.get(labels[i]) < use_limit) {
            num_wanted--;
            largestVals += values[i];
            if (labelsHashMap.containsKey(labels[i])) {
                labelsHashMap.put(labels[i], labelsHashMap.get(labels[i]) + 1);
            } else {
                labelsHashMap.put(labels[i], 1);
            }
        }
    }
    return largestVals;
}
}
