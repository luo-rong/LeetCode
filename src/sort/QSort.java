package sort;

public class QSort {
    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void qSort(int begin, int end, int[] nums) {
        if (end > begin) {
            int l = begin, r = end;
            while (l < r) {
                while (l < r && nums[r] >= nums[begin]) --r;
                while (l < r && nums[l] <= nums[begin]) ++l;
                if (l < r) {
                    swap(l, r, nums);
                }
            }
            swap(begin, l, nums);
            qSort(begin, l - 1, nums);
            qSort(l + 1, end, nums);
        }
    }

    public static void main(String[] args) {
        QSort qSort = new QSort();
        int[] nums = new int[]{9, 7, 6, 4, 2, 1, 0};
        qSort.qSort(0, nums.length - 1, nums);
        for (int num : nums) {
            System.out.print(num + ", ");
        }
    }
}
