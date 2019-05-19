public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int left1 = 0, left2;
        int right1 = nums1.length, right2;
        int point1, point2;
        int left, right;
        while (left1 < right1) {
            point1 = (left1 + right1) / 2;
            left = point1 - left1;
            right = right1 - point1;
            left2 = 0;
            right2 = nums2.length;
            if (nums1[point1] > nums2[right]) {
                left += right2;
            } else if (nums1[point1] < nums2[left]) {
                right += right2;
            } else {
                point2 = 0;
                while (left2 < right2 - 1) {
                    point2 = (left2 + right2) / 2;
                    if (nums2[point2] < nums1[point1]) {
                        left2 = point2;
                    } else {
                        right2 = point2;
                    }
                }
                if (nums2[point2] > nums1[point1]) {
                    left += point2;
                    right += nums2.length - point2;
                } else if (nums2[point2] < nums1[point1]) {
                    left += point2 + 1;
                    right += nums2.length - point2 - 1;
                }
            }
            if (left < right) {
                left1 = point1;
            } else {
                right1 = point1;
            }
        }
        return 0;
    }
}
