package _347_TopKFrequentElements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TopKFrequentElements1 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        int maxNum = 1;
        HashMap<Integer, Integer> numHashMap = new HashMap<>((int) (nums.length / 0.75 + 1));
        for (int num : nums) {
            if (numHashMap.containsKey(num)) {
                maxNum = Math.max(numHashMap.get(num) + 1, maxNum);
                numHashMap.put(num, numHashMap.get(num) + 1);
            } else {
                numHashMap.put(num, 1);
            }
        }
        List<Integer>[] counter = new ArrayList[maxNum + 1];
        for (int i = 0; i < counter.length; ++i) {
            counter[i] = new ArrayList<>();
        }
        for (HashMap.Entry<Integer, Integer> entry : numHashMap.entrySet()) {
            counter[entry.getValue()].add(entry.getKey());
        }
        List<Integer> topKList = new ArrayList<>(k);
        for (int i = counter.length - 1; i >= 0 && topKList.size() < k; --i) {
            topKList.addAll(counter[i]);
        }
        return topKList;
    }
}
