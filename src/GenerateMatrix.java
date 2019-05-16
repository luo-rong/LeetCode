public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int x = 0, y = 0;
        int[][] matrix = new int[n][n];
        int num = 1, maxNum = n * n;
        while (num <= maxNum) {
            if (x == y && x + y == n - 1) {
                matrix[x][y] = num++;
                break;
            }
            while (x + y != n - 1) {
                matrix[x][y++] = num++;
            }
            while (x != y) {
                matrix[x++][y] = num++;
            }
            while (x + y != n - 1) {
                matrix[x][y--] = num++;
            }
            while (x != y) {
                matrix[x--][y] = num++;
            }
            x++;
            y++;
        }
        return matrix;
    }
}
