public class LongestPalindrome {

    private int min(int x, int y) {
        return x > y ? y : x;
    }

    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }
        String result = s.substring(0, 1);
        int maxLen = 1;
        int currLen = 0;
        for (int i = 0; i < s.length(); ++i) {
            // 奇数
            int len = min(i, s.length() - i - 1);
            currLen = 1;
            int j;
            for (j = 1; j <= len; ++j) {
                if (s.charAt(i - j) != s.charAt(i + j)) {
                    break;
                }
                currLen += 2;
            }
            j--;
            if (currLen > maxLen) {
                maxLen = currLen;
                result = s.substring(i - j, i + j + 1);
            }
            if (currLen == s.length()) {
                break;
            }

            // 偶数
            len = min(i + 1, s.length() - i - 1);
            currLen = 0;
            for (j = 1; j <= len; ++j) {
                if (s.charAt(i - j + 1) != s.charAt(i + j)) {
                    break;
                }
                currLen += 2;
            }
            j--;
            if (currLen > maxLen) {
                maxLen = currLen;
                result = s.substring(i - j + 1, i + j + 1);
            }
            if (currLen == s.length()) {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome("aaa"));
        System.out.println(longestPalindrome.longestPalindrome("cbbdd"));
        System.out.println(longestPalindrome.longestPalindrome("aabbbaa"));
        System.out.println(longestPalindrome.longestPalindrome("aaa"));
    }
}
