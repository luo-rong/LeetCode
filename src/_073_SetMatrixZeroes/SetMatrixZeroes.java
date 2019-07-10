package _073_SetMatrixZeroes;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        boolean isFirstColZero = false;
        for (int i = 0; i < matrix.length; ++i) {
            isFirstColZero = matrix[i][0] == 0 || isFirstColZero;
            for (int j = 1; j < matrix[0].length; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = matrix.length - 1; i >= 0; --i) {
            for (int j = 1; j < matrix[0].length; ++j) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            matrix[i][0] = isFirstColZero ? 0 : matrix[i][0];
        }
    }
}