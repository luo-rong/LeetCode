package WeeklyContest111;

public class T1 {
    public boolean validMountainArray(int[] A) {
        int i = 1;
        boolean up = false;
        boolean down = false;
        while ((i < A.length) && (A[i - 1] < A[i])) {
            up = true;
            ++i;
        }
        while (((i < A.length)) && (A[i - 1] > A[i])) {
            down = true;
            ++i;
        }
        if (up && down && (i == A.length)) return true;
        return false;
    }

    public static void main(String[] args) {
        T1 t1 = new T1();
        int[] num = new int[]{};
        System.out.println(t1.validMountainArray(num));
        num = new int[]{1};
        System.out.println(t1.validMountainArray(num));
        num = new int[]{1, 2};
        System.out.println(t1.validMountainArray(num));
        num = new int[]{2, 1};
        System.out.println(t1.validMountainArray(num));
        num = new int[]{1, 1};
        System.out.println(t1.validMountainArray(num));
        num = new int[]{1, 2, 1, 2};
        System.out.println(t1.validMountainArray(num));
        num = new int[]{1, 2, 1};
        System.out.println(t1.validMountainArray(num));
    }
}
