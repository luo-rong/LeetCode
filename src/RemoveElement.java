public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        if (len < 1) return 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == val) {
                nums[i] = nums[len - 1];
                len--;
                i--;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();
        int[] nums = {2, 2, 2, 2};
        System.out.println(removeElement.removeElement(nums, 1));
        for (int i = 0; i < nums.length; ++i) {
            System.out.print(nums[i] + " ");
        }
    }
}