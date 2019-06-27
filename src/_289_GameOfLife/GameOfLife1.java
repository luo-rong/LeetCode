package _289_GameOfLife;

public class GameOfLife1 {
    private int[][] liveBoard;

    private int getStatus(int x, int y) {
        if (x < 0 || x >= liveBoard.length || y < 0 || y >= liveBoard[0].length) {
            return 0;
        } else {
            return liveBoard[x][y];
        }
    }

    private int getLiveNum(int x, int y) {
        int num = 0;
        for (int i = -1; i <= 1; ++i) {
            num += getStatus(x + i, y - 1) + getStatus(x + i, y) + getStatus(x + i, y + 1);
        }
        num -= getStatus(x, y);
        return num;
    }

    public void gameOfLife(int[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        this.liveBoard = board;
        int[][] result = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                int liveNum = getLiveNum(i, j);
                result[i][j] = liveNum == 3 || (board[i][j] == 1 && liveNum == 2) ? 1 : 0;
            }
        }
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                board[i][j] = result[i][j];
            }
        }
    }
}
