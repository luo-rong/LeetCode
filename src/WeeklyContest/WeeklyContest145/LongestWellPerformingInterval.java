package WeeklyContest.WeeklyContest145;

public class LongestWellPerformingInterval {
    public int longestWPI(int[] hours) {
        if (hours.length == 0) {
            return 0;
        }
        int longestWPI = 0;
        int[] count = new int[hours.length];
        count[0] = hours[0] > 8 ? 1 : -1;
        for (int i = 1; i < hours.length; ++i) {
            count[i] = count[i - 1] + (hours[i] > 8 ? 1 : -1);
        }
        for (int i = 0; i < hours.length; ++i) {
            for (int j = i; j < hours.length; ++j) {
                if ((i == 0 && count[j] > 0) || (i > 0 && count[j] - count[i - 1] > 0)) {
                    longestWPI = Math.max(longestWPI, j - i + 1);
                }
            }
        }
        return longestWPI;
    }
}
