package _347_TopKFrequentElements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TopKFrequentElements2 {
    private void exchange(int i, int j) {
        int temp = numArray[i];
        numArray[i] = numArray[j];
        numArray[j] = temp;

        temp = count[i];
        count[i] = count[j];
        count[j] = temp;
    }

    private void qsort(int begin, int end) {
        if (end > begin) {
            int l = begin, r = end;
            while (l < r) {
                while (l < r && count[r] >= count[begin]) --r;
                while (l < r && count[l] <= count[begin]) ++l;
                if (l < r) {
                    exchange(l, r);
                }
            }
            exchange(begin, l);
            qsort(begin, l - 1);
            qsort(l + 1, end);
        }
    }

    private int[] count, numArray;

    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> numHashMap = new HashMap<>((int) (nums.length / 0.75 + 1));
        for (int num : nums) {
            if (numHashMap.containsKey(num)) {
                numHashMap.put(num, numHashMap.get(num) + 1);
            } else {
                numHashMap.put(num, 1);
            }
        }
        this.count = new int[numHashMap.size()];
        this.numArray = new int[numHashMap.size()];
        int length = 0;
        for (HashMap.Entry<Integer, Integer> entry : numHashMap.entrySet()) {
            count[length] = entry.getValue();
            numArray[length++] = entry.getKey();
        }
        qsort(0, this.count.length - 1);
        List<Integer> topKList = new ArrayList<>(k);
        for (int i = this.count.length - 1; i >= 0 && topKList.size() < k; --i) {
            topKList.add(this.numArray[i]);
        }
        return topKList;
    }
}
