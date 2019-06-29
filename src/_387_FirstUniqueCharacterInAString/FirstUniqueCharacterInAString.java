package _387_FirstUniqueCharacterInAString;

import java.util.HashMap;

public class FirstUniqueCharacterInAString {
    public int firstUniqChar1(String s) {
        class Info {
            Info(int index, int count) {
                this.index = index;
                this.count = count;
            }

            int index;
            int count;
        }
        int initialCapacity = (int) (s.length() / 0.75) + 1;
        HashMap<Character, Info> charCounter = new HashMap<>(initialCapacity);
        for (int i = 0; i < s.length(); ++i) {
            if (charCounter.containsKey(s.charAt(i))) {
                Info info = charCounter.get(s.charAt(i));
                info.count++;
//                charCounter.put(s.charAt(i), info);  //不需要回传
            } else {
                charCounter.put(s.charAt(i), new Info(i, 1));
            }
        }
        int minIndex = s.length();
        for (HashMap.Entry<Character, Info> entry : charCounter.entrySet()) {
            if (entry.getValue().count == 1 && entry.getValue().index < minIndex) {
                minIndex = entry.getValue().index;
            }
        }
        return minIndex == s.length() ? -1 : minIndex;
    }

    public int firstUniqChar(String s) {
        int minIndex = s.length();
        for (char ch = 'a'; ch < 'z'; ++ch) {
            int index = s.indexOf(ch);
            if (index != -1 && index < minIndex && index == s.lastIndexOf(ch)) {
                minIndex = index;
            }
        }
        return minIndex == s.length() ? -1 : minIndex;
    }
}
