package _289_GameOfLife;

// 原地算法
public class GameOfLife {
    private static final int DEAD_TO_LIVE_STATUS = 2;
    private static final int LIVE_TO_DEAD_STATUS = 3;

    private int getStatus(int x, int y, int[][] board) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return 0;
        } else if (board[x][y] > 1) {
            return board[x][y] - 2;
        }
        return board[x][y];
    }

    private int getNextStatus(int x, int y, int[][] board) {
        int num = 0;
        for (int i = -1; i <= 1; ++i) {
            num += getStatus(x + i, y - 1, board) + getStatus(x + i, y, board) + getStatus(x + i, y + 1, board);
        }
        num -= board[x][y];
        int status = num == 3 || (board[x][y] == 1 && num == 2) ? 1 : 0;
        if (board[x][y] == 0 && status == 1) {
            status = DEAD_TO_LIVE_STATUS;
        } else if (board[x][y] == 1 && status == 0) {
            status = LIVE_TO_DEAD_STATUS;
        }
        return status;
    }

    public void gameOfLife(int[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                board[i][j] = getNextStatus(i, j, board);
            }
        }
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] > 1) {
                    board[i][j] = 3-board[i][j];
                }
            }
        }
    }

    public static void main(String[] args) {
        GameOfLife gameOfLife = new GameOfLife();
        gameOfLife.gameOfLife(new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}});
    }
}
