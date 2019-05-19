public class PalindromeNumber {
    // 238ms，字符串解法
    public boolean isPalindrome1(int x) {
        String str = String.valueOf(x);
        int len = str.length();
        for (int i = 0; i < len / 2; ++i) {
            if (str.charAt(i) != str.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    // 166ms，翻转全部数字再比较
    public boolean isPalindrome2(int x) {
        int num = x;
        int pNum = 0;
        while (num > 0) {
            pNum = num % 10 + pNum * 10;
            num /= 10;
        }
        return pNum == x;
    }

    // 234ms，翻转一半数字比较
    public boolean isPalindrome(int x) {
        if ((x % 10 == 0) && (x > 0)) return false;
        int num = x;
        int pNum = 0;
        while (pNum < num) {
            pNum = num % 10 + pNum * 10;
            num /= 10;
        }
        return (pNum == num) || (pNum / 10 == num);
    }

    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        System.out.println(palindromeNumber.isPalindrome(1100));
        System.out.println(palindromeNumber.isPalindrome(121));
        System.out.println(palindromeNumber.isPalindrome(-121));
        System.out.println(palindromeNumber.isPalindrome(123321));
        System.out.println(palindromeNumber.isPalindrome(0));
    }
}
