package _877_StoneGame;

public class StoneGame {
    public boolean stoneGame(int[] piles) {
        int[][] dp = new int[piles.length][piles.length];
        for (int i = 0; i < piles.length; ++i) {
            dp[i][i] = piles[i];
        }
        for (int i = piles.length - 2; i >= 0; --i) {
            for (int j = i + 1; j < piles.length; ++j) {
                if ((j - i) % 2 == 1) {
                    dp[i][j] = Math.max(dp[i][j - 1] + piles[j], dp[i + 1][j] + piles[i]);
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1] - piles[j], dp[i + 1][j] - piles[i]);
                }
            }
        }
        return dp[0][piles.length - 1] > 0;
    }
}
