import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest1(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0;
        int differenceValue = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; ++i) {
            if (differenceValue == 0 || (nums[i] >= 0 && nums[i] - target >= differenceValue)) {
                break;
            }
            for (int j = i + 1; j < nums.length - 1; ++j) {
                int sum2 = nums[i] + nums[j];
                if (differenceValue == 0 || (nums[2] >= 0 && sum2 - target >= differenceValue)) {
                    break;
                }
                for (int k = j + 1; k < nums.length; ++k) {
                    int sum3 = sum2 + nums[k];
                    if (differenceValue == 0 || sum3 - target >= differenceValue) {
                        break;
                    }
                    if (differenceValue > Math.abs(sum3 - target)) {
                        differenceValue = Math.abs(sum3 - target);
                        sum = sum3;
                    }
                }
            }
        }
        return sum;
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 0;
        int differenceValue = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length - 1; ++i) {
            int j = i - 1, k = i + 1;
            while (j >= 0 && k < nums.length) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return target;
                } else if (sum > target) {
                    j--;
                } else if (sum < target) {
                    k++;
                }
                if (differenceValue > Math.abs(sum - target)) {
                    result = sum;
                    differenceValue = Math.abs(sum - target);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        System.out.println(threeSumClosest.threeSumClosest(new int[]{0, 1}, 3));
//        System.out.println(threeSumClosest.threeSumClosest(new int[]{-43, 61, -62, 24, 73, 64, -23, 94, -65, -27, 24, -56, 8, 54, 0, 19, -100, -64, -53, 6, -22, 13, -18, 55, -41, 37, 34, -43, 0, -8, -95, 76, 73, 21, -93, 16, 98, 60, 70, -32, 30, -7, -27, -73, 79, -26, 41, 32, 41, -5, 82, -14, 50, -94, 22, 62, 60, -48, 51, 12, -34, 68, -40, -20, -20, 46, 46, -79, 1, 82, -98, 41, -79, -43, -76, -25, -94, -16, -25, 46, -95, -79, 53, -1, -30, 43, 93, 17, 72, 66, 83, -89, -16, 42, 40, 87, -46, 40, 22, 85, -91, 46, -77, 19, -56, -28, 8, 47, -20, 65, 8, 60, -49, -86, -74, 56, 30, 79, 97, -89, 14, -90, 66, -12, -57, 46, -61, 87, 72, 13, 75, 75, 36, 79, -16, 84, -49, -86, 76, 68, -8, -65, -86, -11, 55, -69, -59, 34, 63, 59, -11, 43, 16, 7, 93, 57, -55, 2, 38, 64, 3, 22, -9, -22, -34, -84, 90, -71, -88, 64, -19, 13, -8, -81, -95, -38, -9, -25, 82, 57, 60, -26, 66, 21, 8, 65, -38, -68, -59, 24, 91}, -231));
    }
}
