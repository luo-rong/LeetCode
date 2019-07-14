package BiweeklyContest.BiweeklyContest4;

public class RemoveVowelsFromAString {
    private static final String VOWELS = "aeiou";

    public String removeVowels(String S) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < S.length(); ++i) {
            if (VOWELS.indexOf(S.charAt(i)) == -1) {
                stringBuilder.append(S.charAt(i));
            }
        }
        return stringBuilder.toString();
    }
}
