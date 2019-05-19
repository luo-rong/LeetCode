public class SudokuSolver {
    private static String[] rows = new String[9];
    private static String[] lines = new String[9];
    private static String[] grids = new String[9];
    private static char[][] state = null;

    private boolean dfs(int x, int y) {
        if ((x == 9) && (y == 0)) {
            return true;
        }
        if (state[x][y] == '.') {
            for (Integer i = 1; i < 10; ++i) {
                char num = i.toString().charAt(0);
                // 判断行、列、网格中是否可添加
                int index = y / 3 + ((x / 3) * 3);  // 计算网格编号
                if ((rows[x].indexOf(num) == -1) && (lines[y].indexOf(num) == -1)
                        && (grids[index].indexOf(num) == -1)) {
                    state[x][y] = num;
                    // 调整标记数组的值
                    rows[x] += num;
                    lines[y] += num;
                    grids[index] += num;
                    if (dfs(x + (y + 1) / 9, (y + 1) % 9)) {
                        return true;
                    }
                    // 还原标记数组的值
                    rows[x] = rows[x].substring(0, rows[x].length() - 1);
                    lines[y] = lines[y].substring(0, lines[y].length() - 1);
                    grids[index] = grids[index].substring(0, grids[index].length() - 1);
                    state[x][y] = '.';
                }
            }
        } else {
            return dfs(x + (y + 1) / 9, (y + 1) % 9);
        }
        return false;
    }

    public void solveSudoku(char[][] board) {
        for (int i=0; i<9; ++i) {
            rows[i] = "";
            lines[i] = "";
            grids[i] = "";
        }
        state = board;
        // 初始化行、列、网格
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.') {
                    int index = j / 3 + ((i / 3) * 3);  // 计算网格编号
                    rows[i] += board[i][j];
                    lines[j] += board[i][j];
                    grids[index] += board[i][j];
                }
            }
        }
        dfs(0, 0);
        board = state;
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                System.out.print(board[i][j] + ",");
            }
            System.out.println();
        }
    }

//    private char[][] dfs(int x, int y) {
//        if ((x == 9) && (y == 0)) {
//            return state;
//        }
//        char[][] currState = null;
//        // 当前为空
//        if (state[x][y] == '.') {
//            for (Integer i = 1; i < 10; ++i) {
//                char num = i.toString().charAt(0);
//                // 判断行、列、网格中是否可添加
//                int index = y / 3 + ((x / 3) * 3);  // 计算网格编号
//                if ((rows[x].indexOf(num) == -1) && (lines[y].indexOf(num) == -1)
//                        && (grids[index].indexOf(num) == -1)) {
//                    state[x][y] = num;
//                    // 调整标记数组的值
//                    rows[x] += num;
//                    lines[y] += num;
//                    grids[index] += num;
////                    System.out.println("x = " + x + ", y = " + y + ", num = " + num);
//                    currState = dfs(x + (y + 1) / 9, (y + 1) % 9);
//
//                    // 还原标记数组的值
//                    rows[x] = rows[x].substring(0, rows[x].length() - 1);
//                    lines[y] = lines[y].substring(0, lines[y].length() - 1);
//                    grids[index] = grids[index].substring(0, grids[index].length() - 1);
//                    state[x][y] = '.';
//                    if (currState != null) {
//                        break;
//                    }
//                }
//            }
//        } else {
//            return dfs(x + (y + 1) / 9, (y + 1) % 9);
//        }
//        return currState;
//    }
//
//    public void solveSudoku(char[][] board) {
//
//        for (int i = 0; i < 9; ++i) {
//            rows[i] = "";
//            lines[i] = "";
//            grids[i] = "";
//        }
//        // 初始化行、列、网格
//        for (int i = 0; i < 9; ++i) {
//            for (int j = 0; j < 9; ++j) {
//                if (board[i][j] != '.') {
//                    int index = j / 3 + ((i / 3) * 3);  // 计算网格编号
//                    rows[i] += board[i][j];
//                    lines[j] += board[i][j];
//                    grids[index] += board[i][j];
//                }
//            }
//        }
//        state = board;
//        board = dfs(0, 0);
//        for (int i = 0; i < 9; ++i) {
//            for (int j = 0; j < 9; ++j) {
//                System.out.print(board[i][j] + ",");
//            }
//            System.out.println();
//        }
//    }

    public static void main(String[] args) {
//        char[][] board = {
//                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
//                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
//                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
//                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
//                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
//                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
//                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
//                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
//                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        char[][] board = {
                {'.', '.', '.', '.', '.', '.', '2', '5', '.'},
                {'.', '.', '.', '.', '8', '9', '.', '.', '7'},
                {'.', '.', '.', '2', '.', '.', '.', '.', '8'},
                {'.', '.', '4', '.', '6', '.', '.', '1', '.'},
                {'.', '6', '.', '9', '.', '4', '.', '3', '.'},
                {'.', '7', '.', '.', '2', '.', '5', '.', '.'},
                {'2', '.', '.', '.', '.', '6', '.', '.', '.'},
                {'3', '.', '.', '5', '1', '.', '.', '.', '.'},
                {'.', '8', '9', '.', '.', '.', '.', '.', '.'}};

        SudokuSolver sudokuSolver = new SudokuSolver();
        sudokuSolver.solveSudoku(board);
    }
}
