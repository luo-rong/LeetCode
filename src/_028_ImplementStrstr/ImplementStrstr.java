package _028_ImplementStrstr;

/**
 * 如果用暴力匹配的思路，并假设现在文本串S匹配到 i 位置，模式串P匹配到 j 位置，则有：
 * 如果当前字符匹配成功（即S[i] == P[j]），则i++，j++，继续匹配下一个字符；
 * 如果失配（即S[i]! = P[j]），令i = i - (j - 1)，j = 0。相当于每次匹配失败时，i 回溯，j 被置为0。
 */
public class ImplementStrstr {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); ++i) {
            boolean isFind = true;
            for (int j = 0; j < needle.length(); ++j) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    isFind = false;
                    break;
                }
            }
            if (isFind) {
                return i;
            }
        }
        return -1;
    }
}
