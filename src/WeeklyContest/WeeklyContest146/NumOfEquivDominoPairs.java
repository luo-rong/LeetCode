package WeeklyContest.WeeklyContest146;

import java.util.Arrays;

public class NumOfEquivDominoPairs {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] dominoeNums = new int[dominoes.length];
        for (int i = 0; i < dominoes.length; ++i) {
            dominoeNums[i] = (1 << dominoes[i][0]) + (1 << dominoes[i][1]);
        }
        Arrays.sort(dominoeNums);
        int sameCount = 0, equivDominoPairs = 0;
        for (int i = 1; i < dominoeNums.length; ++i) {
            if (dominoeNums[i - 1] == dominoeNums[i]) {
                sameCount++;
            } else {
                for (; sameCount > 0; --sameCount) {
                    equivDominoPairs += sameCount;
                }
            }
        }
        for (; sameCount > 0; --sameCount) {
            equivDominoPairs += sameCount;
        }
        return equivDominoPairs;
    }

    public static void main(String[] args) {
        int i = 2;
        for (; i > 0; --i) {

        }
        System.out.println(i);
    }
}
