package _378_KthSmallestElementInASortedMatrix;

public class KthSmallestElementInASortedMatrix {
    private int matrixLength;

    private int[] delFirstNum(int[] array) {
        int[] newArray = new int[array.length - 1];
        if (newArray.length == 0) return newArray;
        System.arraycopy(array, 1, newArray, 0, newArray.length);
        return newArray;
    }
    // 插入排序（注意下标！）
    private void matrixSort(int[][] matrix) {
        if (matrixLength == 1) return;
        int i = 1;
        if (matrix[0].length == 0) {
            i = matrixLength--;
        } else if (matrix[1][0] > matrix[0][0]) {
            return;
        } else {
            while (i < matrixLength && matrix[i][0] < matrix[0][0]) ++i;
        }
        int[] temp = matrix[0];
        System.arraycopy(matrix, 1, matrix, 0, --i);
        matrix[i] = temp;
    }

    public int kthSmallest(int[][] matrix, int k) {
        this.matrixLength = matrix.length;
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        for (int i = 0; i < k - 1; ++i) {
            matrix[0] = delFirstNum(matrix[0]);
            matrixSort(matrix);
        }
        return matrix[0][0];
    }

    public static void main(String[] args) {
        KthSmallestElementInASortedMatrix matrix = new KthSmallestElementInASortedMatrix();
        System.out.println(matrix.kthSmallest(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 5));
    }
}
