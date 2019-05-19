public class Search {
    private int[] nums;
    private int target;

    private int getRotationIndex(int begin, int end) {
        int middle = (begin + end) / 2;
        if ((middle == 0 || nums[middle - 1] > nums[middle]) &&
                (middle == nums.length - 1 || nums[middle + 1] > nums[middle])) {
            return middle;
        }
        if (nums[middle] >= nums[end]) {
            return getRotationIndex(middle + 1, end);
        } else {
            return getRotationIndex(begin, middle - 1);
        }
    }

    private int getTargetIndex(int begin, int end) {
        if (begin > end) {
            return -1;
        }
        int middle = (begin + end) / 2;
        if (nums[middle] == target) {
            return middle;
        }
        if (nums[middle] > target) {
            return getTargetIndex(begin, middle - 1);
        } else {
            return getTargetIndex(middle + 1, end);
        }
    }

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        this.nums = nums;
        this.target = target;
        int rotationIndex = getRotationIndex(0, nums.length - 1);
        if (rotationIndex == 0) {
            return getTargetIndex(0, nums.length - 1);
        } else if (nums[0] <= target) {
            return getTargetIndex(0, rotationIndex - 1);
        } else {
            return getTargetIndex(rotationIndex, nums.length - 1);
        }
    }

    public static void main(String[] args) {
        Search search = new Search();
//        search.nums = new int[]{2, 3, 4, 5, 6};
//        search.target = 1;
//        System.out.println(search.getRotationIndex(0, search.nums.length - 1));
        System.out.println(search.search(new int[]{1,2,3}, 1));

    }
}
