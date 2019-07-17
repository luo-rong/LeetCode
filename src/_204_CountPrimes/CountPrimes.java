package _204_CountPrimes;

public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] isPrimes = new boolean[n];
        for (int i = 0; i < n; ++i) {
            isPrimes[i] = true;
        }
        int sqrtN = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrtN; ++i) {
            if (isPrimes[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrimes[j] = false;
                }
            }
        }
        int count = -2;
        for (boolean isPrime : isPrimes) {
            count += isPrime ? 1 : 0;
        }
        return n <= 2 ? 0 : count;
    }
}
