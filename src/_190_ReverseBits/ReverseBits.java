package _190_ReverseBits;

public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            ans |= (n & 1) << (31 - i); // good，因为无进位，故|代替+
            n >>= 1;
        }
        return ans;
    }
}
