package WeeklyContest.WeeklyContest145;

public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] bucket = new int[1001];
        for (int num : arr1) {
            bucket[num]++;
        }
        int[] reSortArr = new int[arr1.length];
        int len = 0;
        for (int num : arr2) {
            if (bucket[num] != 0) {
                for (int i = 0; i < bucket[num]; ++i) {
                    reSortArr[len++] = num;
                }
                bucket[num] = 0;
            }
        }
        for (int i = 0; i < bucket.length; ++i) {
            if (bucket[i] != 0) {
                for (int j = 0; j < bucket[i]; ++j) {
                    reSortArr[len++] = i;
                }
            }
        }
        return reSortArr;
    }
}
