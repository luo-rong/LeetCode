public class ClimbStairs {
    private int[][] combTable;

    private int comb(int n, int m) {
        if (combTable[n][m] != 0) {
            return combTable[n][m];
        }
        m = m > n - m ? n - m : m;
        if (n == 0 || m == 0 || n == m) {
            combTable[n][m] = 1;
        } else {
            combTable[n][m] = comb(n - 1, m - 1) + comb(n - 1, m);
        }
        return combTable[n][m];
    }

    // 组合数求和，数组记录
    public int climbStairs1(int n) {
        combTable = new int[100][100];
        int result = 0;
        for (int i = 0; i <= n >> 1; ++i) {
            result += comb(n - i, i);
        }
        return result;
    }

    // 递归，动态规划，超时
    public int climbStairs2(int n) {
        if (n <= 1) {
            return 1;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    // 数组，动态规划
    public int climbStairs3(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // 斐波那契数列，公式
    public int climbStairs(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
        return (int) (fibn / sqrt5);
    }

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        System.out.println(climbStairs.climbStairs(44));
        System.out.println(climbStairs.climbStairs1(44));
    }
}
