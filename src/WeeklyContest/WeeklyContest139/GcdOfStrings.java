package WeeklyContest.WeeklyContest139;

import java.util.ArrayList;

public class GcdOfStrings {
    private String str1;
    private String str2;

    private int gcd(int a, int b) {
        int c = a > b ? a : b;
        b = b < a ? b : a;
        a = c;
        while (b != 0) {
            c = a % b;
            a = b;
            b = c;
        }
        return a;
    }

    private ArrayList<Integer> getFactor(int num) {
        ArrayList<Integer> factors = new ArrayList<>();
        factors.add(num);
        for (int i = (int) Math.sqrt(num); i >= 1; --i) {
            if (num % i == 0) {
                factors.add(i);
            }
        }
        return factors;
    }

    private boolean isGcdOfStrings(String gcd) {
        StringBuilder strBuild1 = new StringBuilder();
        StringBuilder strBuild2 = new StringBuilder();
        for (int i = 0; i < str1.length() / gcd.length(); ++i) {
            strBuild1.append(gcd);
        }
        for (int i = 0; i < str2.length() / gcd.length(); ++i) {
            strBuild2.append(gcd);
        }
        return str1.equals(strBuild1.toString()) && str2.equals(strBuild2.toString());
    }

    public String gcdOfStrings(String str1, String str2) {
        if (str1.length() == 0 || str2.length() == 0) {
            return "";
        }
        this.str1 = str1;
        this.str2 = str2;
        ArrayList<Integer> lengths = getFactor(gcd(str1.length(), str2.length()));
        for (int length : lengths) {
            String gcd = str1.substring(0, length);
            if (isGcdOfStrings(gcd)) {
                return gcd;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        GcdOfStrings gcdOfStrings = new GcdOfStrings();
        System.out.println(gcdOfStrings.gcdOfStrings("ABABABAB", "ABAB"));
        System.out.println(gcdOfStrings.gcdOfStrings("ABABAB", "ABC"));
        System.out.println(gcdOfStrings.gcdOfStrings("ABABABC", "AB"));
        System.out.println(gcdOfStrings.gcdOfStrings("ABABAB", ""));
    }
}
