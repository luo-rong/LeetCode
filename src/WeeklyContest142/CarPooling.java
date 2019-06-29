package WeeklyContest142;

public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] carSets = new int[1001];
        for (int[] trip : trips) {
            for (int j = trip[1]; j < trip[2]; ++j) {
                carSets[j] += trip[0];
            }
        }
        for (int carSet : carSets) {
            if (carSet > capacity) {
                return false;
            }
        }
        return true;
    }
}
