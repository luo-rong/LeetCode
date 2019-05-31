package _091_NumDecodings;

public class NumDecodings {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= s.length(); ++i) {
            dp[i] = s.charAt(i - 1) != '0' ? dp[i - 1] : 0;
            boolean isLegal = s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) < '7');
            dp[i] += isLegal ? dp[i - 2] : 0;
        }
        return dp[s.length()];
    }
}
