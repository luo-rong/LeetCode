package _125_ValidPalindrome;

public class ValidPalindrome {
    /**
     * 先转换为全小写，可避免输入为：0p 的坑
     */
    private boolean isNumOrChar(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9');
    }

    public boolean isPalindrome1(String s) {
        s = s.toLowerCase();
        StringBuilder pureStr = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            if (isNumOrChar(s.charAt(i))) {
                pureStr.append(s.charAt(i));
            }
        }
        for (int i = 0, j = pureStr.length() - 1; i < j; ++i, --j) {
            if (pureStr.charAt(i) != pureStr.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome2(String s) {
        s = s.toLowerCase();
        for (int i = 0, j = s.length() - 1; i < j; ++i, --j) {
            while (i < j && !isNumOrChar(s.charAt(i))) {
                ++i;
            }
            while (i < j && !isNumOrChar(s.charAt(j))) {
                --j;
            }
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
