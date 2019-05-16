public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int left = 1, right = 1;
        output[0] = 1;
        for (int i = 1; i < nums.length; ++i) {
            left *= nums[i - 1];
            output[i] += left;
        }
        for (int i = nums.length - 2; i > -1; --i) {
            right *= nums[i + 1];
            output[i] *= right;
        }
        return output;
    }
}
