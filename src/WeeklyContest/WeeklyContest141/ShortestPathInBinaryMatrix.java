package WeeklyContest.WeeklyContest141;

import java.util.ArrayDeque;
import java.util.Queue;


public class ShortestPathInBinaryMatrix {
    class Point {
        private int x;
        private int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    private Queue<Point> pointQueue;
    private int[][] pathLength;
    private int length;
    private int[][] grid;

    private boolean isEmpty(Point point, int i, int j) {
        if (i == 0 && j == 0) {
            return false;
        }
        int x = point.getX() + i;
        int y = point.getY() + j;
        return !(x < 0 || y < 0 || x >= length || y >= length || grid[x][y] == 1);
    }

    private void update(Point point) {
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                if (isEmpty(point, i, j) && pathLength[point.getX()][point.getY()] + 1 < pathLength[point.getX() + i][point.getY() + j]) {
                    pathLength[point.getX() + i][point.getY() + j] = pathLength[point.getX()][point.getY()] + 1;
                    Point newPoint = new Point(point.getX() + i, point.getY() + j);
                    pointQueue.add(newPoint);
                }
            }
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        this.grid = grid;
        this.length = grid.length;
        this.pointQueue = new ArrayDeque<>();
        if (length == 0 || grid[length - 1][length - 1] == 1) {
            return -1;
        }

        pathLength = new int[length][length];
        for (int i = 0; i < length; ++i) {
            for (int j = 0; j < length; ++j) {
                pathLength[i][j] = Integer.MAX_VALUE;
            }
        }
        Point endPoint = new Point(length - 1, length - 1);
        pointQueue.add(endPoint);
        pathLength[length - 1][length - 1] = 1;

        while (!pointQueue.isEmpty()) {
            update(pointQueue.poll());
        }
        return pathLength[0][0] == Integer.MAX_VALUE ? -1 : pathLength[0][0];
    }

    public static void main(String[] args) {
        ShortestPathInBinaryMatrix matrix = new ShortestPathInBinaryMatrix();
        System.out.println(matrix.shortestPathBinaryMatrix(new int[][]{{0}}));
        System.out.println(matrix.shortestPathBinaryMatrix(new int[][]{}));

//        System.out.println(matrix.shortestPathBinaryMatrix(new int[][]{{0, 0, 0}, {1, 1, 0}, {1, 1, 0}}));
//        System.out.println(matrix.shortestPathBinaryMatrix(new int[][]{{0, 0, 1, 1, 1}, {1, 0, 1, 1, 1}, {0, 0, 1, 1, 1}, {0, 1, 1, 1, 1}, {0, 0, 0, 0, 0}}));
    }
}
