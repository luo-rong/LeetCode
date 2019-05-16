import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length - 1;
        if (m < 0) return result;
        int n = matrix[0].length - 1;
        if (n < 0) return result;
        int x = 0, y = 0;
        while (true) {
            // 2*2 结束
            if (x > m / 2 || y > n / 2) break;
            // 右上拐点
            while (x + y < n) {
                result.add(matrix[x][y]);
                ++y;
            }
            // 1*n 结束
            if (x + n == y + m) {
                result.add(matrix[x][y]);
                break;
            }
            // 右下拐点
            while (x + n < y + m) {
                result.add(matrix[x][y]);
                ++x;
            }
            // n*1 结束
            if (x + y == m) {
                result.add(matrix[x][y]);
                break;
            }
            // 左下拐点
            while (x + y > m) {
                result.add(matrix[x][y]);
                --y;
            }
            // 左上拐点
            while (x > y) {
                result.add(matrix[x][y]);
                --x;
            }
            x++;
            y++;
        }
        return result;
    }

    public static void main(String[] args) {
        SpiralOrder spiralOrder = new SpiralOrder();
        List<Integer> list = spiralOrder.spiralOrder
                (new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        for (Integer num : list) {
            System.out.print(num + " ");
        }
        // 空数组
        list = spiralOrder.spiralOrder
                (new int[][]{});
        for (Integer num : list) {
            System.out.print(num + " ");
        }
        // 单一数字结束
        list = spiralOrder.spiralOrder
                (new int[][]{{1}});
        for (Integer num : list) {
            System.out.print(num + " ");
        }
    }
}
