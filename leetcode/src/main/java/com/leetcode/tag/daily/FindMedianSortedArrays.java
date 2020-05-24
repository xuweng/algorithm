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
  static class Solution1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      int[] left = new int[nums1.length + 1];
      int[] right = new int[nums2.length + 1];

      left[left.length - 1] = Integer.MAX_VALUE;
      right[right.length - 1] = Integer.MAX_VALUE;

      System.arraycopy(nums1, 0, left, 0, nums1.length);
      System.arraycopy(nums2, 0, right, 0, nums2.length);

      int length = nums1.length + nums2.length;
      int[] result = new int[length];
      int leftIndex = 0, rightIndex = 0;
      for (int i = 0; i <= length / 2; i++) {
        if (left[leftIndex] < right[rightIndex]) {
          result[i] = left[leftIndex];
          leftIndex++;
        } else {
          result[i] = right[rightIndex];
          rightIndex++;
        }
      }
      if (length % 2 == 0) {
        return (result[length / 2 - 1] + result[length / 2]) / 2.0;
      } else {
        return result[length / 2];
      }
    }
  }
}
