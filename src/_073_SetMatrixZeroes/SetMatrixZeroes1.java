package _073_SetMatrixZeroes;

public class SetMatrixZeroes1 {
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int[] line = new int[matrix.length];
        int[] row = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (matrix[i][j] == 0) {
                    line[i] = 1;
                    row[j] = 1;
                }
            }
        }
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (line[i] == 1 || row[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
