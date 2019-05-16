import java.util.Arrays;

public class FindKthLargest {

    private int[] nums;
    private int k;

    private void sort(int x, int y) {
        if (x >= y) return;
        int key = nums[x];
        int i = x ;
        int j = y;
        while (i < j) {
            while ((nums[i] >= key) && (i < j)) ++i;
            while ((nums[j] < key) && (j >= i)) --j;
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        int temp = nums[x];
        nums[x] = nums[j];
        nums[j] = temp;
        if (j > this.k) {
            sort(x, j - 1);
        } else if (j < this.k) {
            sort(j + 1, y);
        }
    }

    public int findKthLargest1(int[] nums, int k) {
        this.nums = nums;
        this.k = k - 1;
        sort(0, nums.length - 1);
        return nums[this.k];
    }

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    public static void main(String[] args) {
        FindKthLargest findKthLargest = new FindKthLargest();
         System.out.println(findKthLargest.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6}, 2));
        System.out.println(findKthLargest.findKthLargest(new int[]{5,2,4,1,3,6,0}, 4));
    }
}
