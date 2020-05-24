package com.leetcode.tag.daily;

import java.util.Arrays;

/**
 * 4. 寻找两个正序数组的中位数
 */
public class FindMedianSortedArrays {
  /** 暴力法 */
  class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      int[] nums3 = concat(nums1, nums2);
      if (nums3.length == 1) {
        return nums3[0];
      }
      Arrays.sort(nums3);

      int index = nums3.length >> 1;
      if (nums3.length % 2 == 0) {
        return (nums3[index] + nums3[index - 1]) / 2.0;
      } else {
        return nums3[index];
      }
    }

    public int[] concat(int[] a, int[] b) {
      int[] c = new int[a.length + b.length];
      System.arraycopy(a, 0, c, 0, a.length);
      System.arraycopy(b, 0, c, a.length, b.length);
      return c;
    }
  }

  /** 归并排序 */
  class Solution1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      int nums1Index = 0, nums2Index = 0;
      int totalLength = nums1.length + nums2.length;
      int mid = totalLength >> 1;

      for (int i = 0; (i < totalLength) && (nums1Index + nums2Index < mid); i++) {
        if (nums1Index < nums1.length && nums1[nums1Index] <= nums2[nums2Index]) {
          nums1Index++;
        } else if (nums2Index < nums2.length && nums1[nums1Index] > nums2[nums2Index]) {
          nums2Index++;
        }
      }
      if (nums1Index == nums1.length) {
        return nums2[nums2Index];
      }
      if (nums2Index == nums2.length) {
        return nums1[nums1Index];
      }
      return totalLength % 2 == 0
              ? (nums1[nums1Index] + nums2[nums2Index]) / 2.0
              : Math.min(nums1[nums1Index], nums2[nums2Index]);
    }
  }
}
