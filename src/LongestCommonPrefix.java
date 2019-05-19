public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        // 当输入为空 new String[]{} 时
        if (strs.length == 0) return "";
        String result = strs[0];
        for (String str : strs) {
            if (result.length() > str.length()) {
                result = result.substring(0, str.length());
            }
            for (int i = 0; i < result.length(); ++i) {
                if (str.charAt(i) != result.charAt(i)) {
                    result = result.substring(0, i);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{}));
        String str = "ab";
        System.out.println(str.substring(0, 0));
    }
}
