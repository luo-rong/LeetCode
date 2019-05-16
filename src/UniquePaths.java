public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        int[][] answer = new int[m][n];
        for (int x = 0; x < m; ++x) {
            answer[x][0] = 1;
        }
        for (int y = 0; y < n; ++y) {
            answer[0][y] = 1;
        }
        for (int x = 1; x < m; ++x) {
            for (int y = 1; y < n; ++y) {
                answer[x][y] = answer[x - 1][y] + answer[x][y - 1];
            }
        }
        return answer[m - 1][n - 1];
    }
}
