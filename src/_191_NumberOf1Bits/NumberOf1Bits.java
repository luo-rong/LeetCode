package _191_NumberOf1Bits;

public class NumberOf1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight1(int n) {
        String strN = Integer.toBinaryString(n);
        int weight = 0;
        for (int i = 0; i < strN.length(); ++i) {
            weight = strN.charAt(i) == '1' ? weight + 1 : weight;
        }
        return weight;
    }

    private static final int NUM = 1 << 31;

    public int hammingWeight2(int n) {
        int weight = 0;
        do {
            weight = (n & NUM) == NUM ? weight + 1 : weight;
        } while ((n = n << 1) != 0);
        return weight;
    }

    public int hammingWeight(int n) {
        int weight = 0;
        for (int i = 0; i < 32; ++i) {
            weight = (n & 1) == 1 ? weight + 1 : weight;
        }
        return weight;
    }
}
