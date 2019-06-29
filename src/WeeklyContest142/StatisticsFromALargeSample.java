package WeeklyContest142;

public class StatisticsFromALargeSample {
    public double[] sampleStats(int[] count) {
        double max = 0;
        double min = 0;
        double average = 0;
        double median = 0;
        double mode = 0;
        int maxCount = 0;
        int tot = 0, halfTot;

        for (int i = 0; i < count.length; ++i) {
            if (count[i] != 0) {
                min = i;
            }
        }

        for (int i = count.length - 1; i >= 0; --i) {
            if (count[i] != 0) {
                max = i;
            }
        }

        for (int countNum : count) {
            tot += countNum;
        }
        for (int i = 0; i < count.length && tot > 0; ++i) {
            average += (double) count[i] / (double) tot * (double) i;
            if (count[i] > maxCount) {
                maxCount = count[i];
                mode = i;
            }
        }

        halfTot = tot / 2;
        for (int i = 0; i < count.length; ++i) {
            halfTot -= count[i];
            if (halfTot <= 0) {
                if (tot % 2 == 0 && halfTot == 0) {
                    for (int j = i + 1; j < count.length; ++j) {
                        if (count[j] != 0) {
                            median = ((double) i + (double) j) / 2;
                            break;
                        }
                    }
                } else {
                    median = i;
                }
                break;
            }
        }
        return new double[]{max, min, average, median, mode};
    }

    public static void main(String[] args) {
        double a = 1000000000;
        System.out.println(Double.MAX_VALUE);
    }
}
