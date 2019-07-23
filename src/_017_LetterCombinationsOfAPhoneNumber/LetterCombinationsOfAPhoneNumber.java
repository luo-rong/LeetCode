package _017_LetterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.List;


public class LetterCombinationsOfAPhoneNumber {
    enum LettersOfNum {
        //
        NUM_2('2', "abc"),
        NUM_3('3', "def"),
        NUM_4('4', "ghi"),
        NUM_5('5', "jkl"),
        NUM_6('6', "mno"),
        NUM_7('7', "pqrs"),
        NUM_8('8', "tuv"),
        NUM_9('9', "wxyz"),
        ;
        private char num;
        private String letters;

        LettersOfNum(char num, String letters) {
            this.num = num;
            this.letters = letters;
        }

        static public String getLetters(int num) {
            for (LettersOfNum lettersOfNum : LettersOfNum.values()) {
                if (lettersOfNum.num == num) {
                    return lettersOfNum.letters;
                }
            }
            return "";
        }

    }

    private List<String> combinations;
    private int length;
    private String digits;

    private void makeCombinations(int index, StringBuilder str) {
        if (index == length) {
            combinations.add(new String(str));
            return;
        }
        String letters = LettersOfNum.getLetters(digits.charAt(index));
        for (int i = 0; i < letters.length(); ++i) {
            makeCombinations(index + 1, str.append(letters.charAt(i)));
            str.deleteCharAt(index);
        }
    }

    public List<String> letterCombinations(String digits) {
        this.digits = digits;
        this.length = digits.length();
        this.combinations = new ArrayList<>();
        if (length > 0) {
            makeCombinations(0, new StringBuilder());
        }
        return this.combinations;
    }
}