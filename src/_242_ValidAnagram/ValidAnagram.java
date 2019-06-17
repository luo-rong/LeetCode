package _242_ValidAnagram;

import java.util.HashMap;

public class ValidAnagram {
    // 方法1
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> charHashMap = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); ++i) {
            if (charHashMap.containsKey(s.charAt(i))) {
                charHashMap.put(s.charAt(i), charHashMap.get(s.charAt(i)) + 1);
            } else {
                charHashMap.put(s.charAt(i), 1);
            }
        }
        for (int i = 0; i < t.length(); ++i) {
            if (charHashMap.containsKey(t.charAt(i)) && charHashMap.get(t.charAt(i)) > 0) {
                charHashMap.put(t.charAt(i), charHashMap.get(t.charAt(i)) - 1);
            } else {
                return false;
            }
        }
        return true;
    }

    // 方法2
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] charArray = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            charArray[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); ++i) {
            if (--charArray[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    // 方法3，fast
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] charArray = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            charArray[s.charAt(i) - 'a']++;
            charArray[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; ++i) {
            if (charArray[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
