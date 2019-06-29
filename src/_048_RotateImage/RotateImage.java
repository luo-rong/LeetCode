package _048_RotateImage;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // foreach 矩形环
        for (int i = 0; i < n >> 1; ++i) {
            int length = n - 1 - (i << 1);
            // 逆时针旋转
            for (int j = 0; j < length; ++j) {
                int temp = matrix[i][i + j];
                matrix[i][i + j] = matrix[n - 1 - i - j][i];
                matrix[n - 1 - i - j][i] = matrix[n - 1 - i][n - 1 - i - j];
                matrix[n - 1 - i][n - 1 - i - j] = matrix[i + j][n - 1 - i];
                matrix[i + j][n - 1 - i] = temp;
            }
        }
    }
}
