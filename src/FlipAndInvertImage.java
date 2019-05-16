public class FlipAndInvertImage {
    public int[][] flipAndInvertImage(int[][] A) {
        int len1 = A.length;
        int len2 = A[0].length;
        int[][] B = new int[len1][len2];
        for (int i = 0; i < len1; ++i) {
            for (int j = 0; j < len2; ++j) {
                B[i][j] = 1 - A[i][len2 - j - 1];
            }
        }
        return B;
    }
}
