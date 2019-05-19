public class Search_1 {
    private int[] nums;
    private int target;

    private int getTargetIndex1(int begin, int end) {
        if (begin > end) {
            return -1;
        }
        int middle = (begin + end) / 2;
        if (target == nums[middle]) {
            return middle;
        } else if (nums[middle] >= nums[begin] && nums[middle] <= nums[end]) {
            if (target < nums[middle]) {
                return getTargetIndex(begin, middle - 1);
            } else {
                return getTargetIndex(middle + 1, end);
            }
        } else if (nums[middle] >= nums[begin]) {
            if (target > nums[middle]) {
                return getTargetIndex(middle + 1, end);
            } else {
                if (target >= nums[begin]) {
                    return getTargetIndex(begin, middle - 1);
                } else if (target <= nums[end]) {
                    return getTargetIndex(middle + 1, end);
                }
            }
        } else if (nums[middle] <= nums[end]) {
            if (target < nums[middle]) {
                return getTargetIndex(begin, middle - 1);
            } else {
                if (target >= nums[begin]) {
                    return getTargetIndex(begin, middle - 1);
                } else if (target <= nums[end]) {
                    return getTargetIndex(middle + 1, end);
                }
            }
        }
        return -1;
    }

    private int getTargetIndex(int begin, int end) {
        if (begin > end) {
            return -1;
        }
        int middle = (begin + end) / 2;
        if (target == nums[middle]) {
            return middle;
        } else if (nums[middle] >= nums[begin]) {
            if (target < nums[middle] && target >= nums[begin]) {
                return getTargetIndex(begin, middle - 1);
            }
            return getTargetIndex(middle + 1, end);
        } else if (nums[middle] < nums[end]) {
            if (target > nums[middle] && target <= nums[end]) {
                return getTargetIndex(middle + 1, end);
            }
            return getTargetIndex(begin, middle - 1);
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        return getTargetIndex(0, nums.length - 1);
    }

    public static void main(String[] args) {
        Search_1 search = new Search_1();
        System.out.println(search.search(new int[]{8, 0}, 0));
    }
}
