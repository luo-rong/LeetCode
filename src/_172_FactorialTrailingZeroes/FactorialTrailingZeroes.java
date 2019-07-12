package _172_FactorialTrailingZeroes;

public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int totCount5 = n / 5;
        int count = 0;
        while (n >= 5) {
            n /= 5;
            ++count;
        }
        System.out.println(count);
        for (int i = 0; i < count; ++i) {
            totCount5 += i;
        }
        return totCount5;
    }
}
