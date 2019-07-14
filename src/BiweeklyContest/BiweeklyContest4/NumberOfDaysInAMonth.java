package BiweeklyContest.BiweeklyContest4;

public class NumberOfDaysInAMonth {
    public int numberOfDays(int Y, int M) {
        if (M == 4 || M == 6 || M == 9 || M == 11) {
            return 30;
        } else if (M == 2) {
            if ((Y % 100 != 0 && Y % 4 == 0) || (Y % 400 == 0)) {
                return 29;
            } else {
                return 28;
            }
        }
        return 31;
    }
}
