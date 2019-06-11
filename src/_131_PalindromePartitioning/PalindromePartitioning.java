package _131_PalindromePartitioning;


import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() >> 1; ++i) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public List<List<String>> partition(String s) {
        int length = s.length();
        if (length <= 0) {
            List<List<String>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }
        List<List<List<String>>> palindromeList = new ArrayList<>(length);
        for (int i = 0; i < length; ++i) {
            List<List<String>> subPalindromeList = new ArrayList<>();
            for (int j = i; j >= 0; --j) {
                String subStr = s.substring(j, i + 1);
                if (isPalindrome(subStr)) {
                    if (j > 0) {
                        for (List<String> list : palindromeList.get(j - 1)) {
                            List<String> newList = new ArrayList<>();
                            newList.addAll(list);
                            newList.add(subStr);
                            subPalindromeList.add(newList);
                        }
                    } else {
                        List<String> newList = new ArrayList<>();
                        newList.add(subStr);
                        subPalindromeList.add(newList);
                    }
                }
            }
            palindromeList.add(subPalindromeList);
        }
        return palindromeList.get(length - 1);
    }
}
