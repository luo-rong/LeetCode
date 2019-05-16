public class CountBits {
    public int[] countBits1(int num) {
        int[] result = new int[num + 1];
        int i = 1, j = 0, len = 1;
        while (i <= num) {
            while (i <= num && j < len) {
                result[i++] = result[j++] + 1;
            }
            j = 0;
            len <<= 1;
        }
        return result;
    }

    public int[] countBits2(int num) {
        int[] result = new int[num + 1];
        for (int i = 1; i <= num; ++i) {
            result[i] = result[i & (i - 1)] + 1;
        }
        return result;
    }

    // fast
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 1; i <= num; ++i) {
            result[i] = result[i >> 1] + (i & 1);
        }
        return result;
    }
}