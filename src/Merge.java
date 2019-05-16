public class Merge {
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = new int[m];
        System.arraycopy(nums1, 0, nums3, 0, m);
        int i = 0, j = 0, k = 0;
        while (j < n || k < m) {
            while (j < n && (k == m || nums2[j] <= nums3[k])) {
                nums1[i++] = nums2[j++];
            }
            while (k < m && (j == n || nums2[j] > nums3[k])) {
                nums1[i++] = nums3[k++];
            }
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-- + n-- - 1;
        while (i >= 0) {
            while (m >= 0 && (n < 0 || nums1[m] >= nums2[n])) {
                nums1[i--] = nums1[m--];
            }
            while (n >= 0 && (m < 0 || nums1[m] < nums2[n])) {
                nums1[i--] = nums2[n--];
            }
        }
    }
}
