package _171_TitleToNumber;

public class TitleToNumber {
    final int WEIGHT_VALUE = 26;
    final int REFERENCE_VALUE = 'A' - 1;

    public int titleToNumber(String s) {
        int lineNum = 0;
        for (int i = 0; i < s.length(); ++i) {
            lineNum = lineNum * WEIGHT_VALUE + s.charAt(i) - REFERENCE_VALUE;
        }
        return lineNum;
    }
}
