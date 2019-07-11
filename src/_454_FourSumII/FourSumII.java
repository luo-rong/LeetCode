package _454_FourSumII;

import java.util.HashMap;

public class FourSumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int length = A.length;
        HashMap<Integer, Integer> ABHashMap = new HashMap<>((int) (length * length / 0.75) + 1);
        for (int a : A) {
            for (int b : B) {
                if (ABHashMap.containsKey(a + b)) {
                    ABHashMap.put(a + b, ABHashMap.get(a + b) + 1);
                } else {
                    ABHashMap.put(a + b, 1);
                }
            }
        }
        int count = 0;
        for (int c : C) {
            for (int d : D) {
                if (ABHashMap.containsKey(-c - d)) {
                    count += ABHashMap.get(-c - d);
                }
            }
        }
        return count;
    }
}
