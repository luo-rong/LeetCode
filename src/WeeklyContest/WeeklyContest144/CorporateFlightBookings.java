package WeeklyContest.WeeklyContest144;

public class CorporateFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] counters = new int[n];
        for (int[] booking : bookings) {
            counters[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                counters[booking[1]] -= booking[2];
            }
        }
        int[] result = new int[n];
        int value = 0;
        for (int i = 0; i < n; ++i) {
            value += counters[i];
            result[i] = value;
        }
        return result;
    }
}
