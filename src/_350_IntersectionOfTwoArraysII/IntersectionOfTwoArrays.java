package _350_IntersectionOfTwoArraysII;

import java.util.Arrays;

public class IntersectionOfTwoArrays {
    public int[] intersect1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, k = 0;
        int[] intersectionNum = new int[Math.min(nums1.length, nums2.length)];
        while (i < nums1.length && j < nums2.length) {
            while (j < nums2.length && nums1[i] > nums2[j]) {
                j++;
            }
            if (j < nums2.length) {
                while (i < nums1.length && nums1[i] < nums2[j]) {
                    i++;
                }
                if (i < nums1.length && nums1[i] == nums2[j]) {
                    intersectionNum[k++] = nums1[i++];
                    j++;
                }
            }
        }
        int[] result = new int[k];
        System.arraycopy(intersectionNum, 0, result, 0, k);
        return result;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, len1 = nums1.length, len2 = nums2.length;
        int[] intersectionNum = new int[Math.min(len1, len2)];
        for (int num1 : nums1) {
            while (i < len2 && num1 > nums2[i]) {
                i++;
            }
            if (i < len2 && num1 == nums2[i]) {
                intersectionNum[j++] = nums2[i++];
            }
        }
        int[] result = new int[j];
        System.arraycopy(intersectionNum, 0, result, 0, j);
        return result;
    }
}
