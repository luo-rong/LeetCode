package WeeklyContest.WeeklyContest111;

public class T2 {
    public int minDeletionSize(String[] A) {
        if (A.length == 0) return 0;
        int del = 0;
        for (int i = 0; i < A[0].length(); ++i) {
            for (int j = 1; j < A.length; ++j) {
                if (A[j].charAt(i) < A[j - 1].charAt(i)) {
                    del++;
                    break;
                }
            }
        }
        return del;
    }

    public static void main(String[] args) {
        T2 t2 = new T2();
        String[] strs = new String[]{"rrjk", "furt", "guzm"};
        System.out.println(t2.minDeletionSize(strs));
        strs = new String[]{"a", "b"};
        System.out.println(t2.minDeletionSize(strs));
        strs = new String[]{"zyx", "wvu", "tsr"};
        System.out.println(t2.minDeletionSize(strs));
        strs = new String[]{};
        System.out.println(t2.minDeletionSize(strs));
        strs = new String[]{"a"};
        System.out.println(t2.minDeletionSize(strs));
        strs = new String[]{"a", "a"};
        System.out.println(t2.minDeletionSize(strs));
    }
}
