public class IsPowerOfTwo {
    public boolean isPowerOfTwo1(int n) {
        if (n <= 0) {
            return false;
        }
        return ((n ^ (n - 1)) ^ (((n - 1) << 1) + 1)) == 0;
    }

    public boolean isPowerOfTwo(int n) {
        return (n > 0) && (n & -n) == n;
    }

    public static void main(String[] args) {
        IsPowerOfTwo isPowerOfTwo = new IsPowerOfTwo();
        System.out.println(isPowerOfTwo.isPowerOfTwo(64));
    }
}
