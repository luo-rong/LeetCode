import java.util.Stack;

public class ReverseWords {
    public String reverseWords1(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> word = new Stack<>();
        StringBuilder result = new StringBuilder();
        for (char ch : chars) {
            if (ch == ' ') {
                while (word.size() > 0) {
                    result.append(word.pop());
                }
                result.append(" ");
            } else {
                word.push(ch);
            }
        }
        while (word.size() > 0) {
            result.append(word.pop());
        }
        return result.toString();
    }

    public String reverseWords(String s) {
        String[] strList = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (String str : strList) {
            StringBuilder stringBuilder = new StringBuilder(str);
            stringBuilder.reverse();
            result.append(stringBuilder);
            result.append(" ");
        }
        return result.substring(0, result.length() - 1);
    }

    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();
        System.out.println(reverseWords.reverseWords("abc acb"));
    }
}
