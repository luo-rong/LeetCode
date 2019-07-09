package _049_GroupAnagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    private String getStrHashCode(String string) {
        int[] codes = new int[26];
        for (int i = 0; i < string.length(); ++i) {
            codes[string.charAt(i) - 'a']++;
        }
        StringBuilder hashCode = new StringBuilder();
        for (int code : codes) {
            hashCode.append(code).append("-");
        }
        return hashCode.toString();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> strHashMap = new HashMap<>((int) (strs.length / 0.75) + 1);
        for (String str : strs) {
            String strHashCode = getStrHashCode(str);
            if (!strHashMap.containsKey(strHashCode)) {
                strHashMap.put(strHashCode, new ArrayList<>());
            }
            strHashMap.get(strHashCode).add(str);
        }
        return new ArrayList<>(strHashMap.values());    // good!
    }
}