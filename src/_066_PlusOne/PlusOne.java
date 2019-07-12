package _066_PlusOne;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        digits[digits.length - 1]++;
        for (int i = digits.length - 1; i > 0 && digits[i] > 9; --i) {
            digits[i - 1]++;
            digits[i] -= 10;
        }
        int[] result;
        if (digits[0] > 9) {
            digits[0] -= 10;
            result = new int[digits.length + 1];
            System.arraycopy(digits, 0, result, 1, digits.length);
            result[0] = 1;
        } else {
            result = digits;
        }
        return result;
    }
}
