package _036_ValidSudoku;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int[][] box = new int[9][9], line = new int[9][9], row = new int[9][9];
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    if (box[i / 3 * 3 + j / 3][num]++ != 0 || line[i][num]++ != 0 || row[j][num]++ != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
