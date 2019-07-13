package WeeklyContest.WeeklyContest141;

public class DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == 0) {
                System.arraycopy(arr, i, arr, i + 1, arr.length - i - 1);
                ++i;
            }
        }
    }

    public static void main(String[] args) {
        DuplicateZeros duplicateZeros = new DuplicateZeros();
        duplicateZeros.duplicateZeros(new int[]{1,0,2,3,0,4,5,0});
    }
}
