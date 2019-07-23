package WeeklyContest.WeeklyContest146;

// 超时
public class MaximumOfAbsoluteValueExpression {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int maxValue = 0;
        for (int i = 0; i < arr1.length; ++i) {
            for (int j = i + 1; j < arr1.length; ++j) {
                int value = Math.abs(arr1[i] - arr1[j]) + Math.abs(arr2[i] - arr2[j]) + (j - i);
                maxValue = Math.max(maxValue, value);
            }
        }
        return maxValue;
    }
}
