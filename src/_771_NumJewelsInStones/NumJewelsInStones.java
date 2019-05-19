package _771_NumJewelsInStones;

public class NumJewelsInStones {
    public int numJewelsInStones(String J, String S) {
        int sum = 0;
        for (int i = 0; i < J.length(); ++i) {
            for (int j = 0; j < S.length(); ++j) {
                sum = J.charAt(i) == S.charAt(j) ? ++sum : sum;
            }
        }
        return sum;
    }
}
