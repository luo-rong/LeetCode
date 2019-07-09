package _013_RomanToInteger;

public class RomanToInteger {
    enum RomanNum {
        // 罗马数字
        I('I', 1),
        V('V', 5),
        X('X', 10),
        L('L', 50),
        C('C', 100),
        D('D', 500),
        M('M', 1000);
        private char roman;
        private int integer;

        RomanNum(char roman, int integer) {
            this.roman = roman;
            this.integer = integer;
        }

        static int getInteger(char ch) {
            for (RomanNum romanNum : RomanNum.values()) {
                if (romanNum.roman == ch) {
                    return romanNum.integer;
                }
            }
            return 0;
        }
    }

    public int romanToInt(String s) {
        int integer = 0;
        int lastBit = 0, currBit = 0;
        for (int i = 0; i < s.length(); ++i) {
            currBit = RomanNum.getInteger(s.charAt(i));
            if (currBit > lastBit) {
                integer -= lastBit;
            } else {
                integer += lastBit;
            }
            lastBit = currBit;
        }
        integer += currBit;
        return integer;
    }
}
