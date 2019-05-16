public class SingleNumber {
    public int singleNumber(int[] nums) {
        int tot = 0;
        for (int i = 0; i < nums.length; ++i) {
            tot = tot ^ nums[i];
        }
        return tot;
    }

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        System.out.println(singleNumber.singleNumber(new int[]{1,1,2}));
    }
}
