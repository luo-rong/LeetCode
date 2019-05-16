public class Multiply {
    public String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        int[] digit = new int[len1 + len2];
        StringBuffer num = new StringBuffer();
        for (int i = 0; i < len1; ++i) {
            int digit1 = num1.charAt(len1 - 1 - i) - '0';
            for (int j = 0; j < len2; ++j) {
                int digit2 = num2.charAt(len2 - 1 - j) - '0';
                digit[i + j] += digit1 * digit2;
                // 进位处理1
//                digit[i + j + 1] += digit[i + j] / 10;
//                digit[i + j] = digit[i + j] % 10;
            }
        }
        // 进位处理2
        for (int i = 0; i < len1 + len2 - 1; ++i) {
            digit[i + 1] += digit[i] / 10;
            digit[i] = digit[i] % 10;
        }
        int len = len1 + len2;
        while (len > 1 && digit[len - 1] == 0) {
            len--;
        }
        for (int i = len - 1; i >= 0; --i) {
            num.append(digit[i]);
        }
        return num.toString();
    }

    public static void main(String[] args) {
        Multiply multiply = new Multiply();
        System.out.println(multiply.multiply("0", "456"));
    }
}
