package com.leetcode.tag.divide;

import java.util.Arrays;

/**
 * 审题
 *
 * <p>审题.审题.审题.审题
 *
 * <p>两个数组上用分治
 *
 * <p>一个数组上用分治
 *
 * <p>一个数组.两个数组
 *
 * <p>4. 寻找两个正序数组的中位数
 */
public class MedianTwoSorted {
  /**
   * 审题正确
   *
   * <p>审题正确
   *
   * @param nums1
   * @param nums2
   * @return
   */
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int[] nums3 = concat(nums1, nums2);
    if (nums3.length == 1) {
      return nums3[0];
    }
    Arrays.sort(nums3);

    int index = nums3.length >> 1;
    return nums3.length % 2 == 0 ? (nums3[index] + nums3[index - 1]) / 2.0 : nums3[index];
  }

  public int[] concat(int[] a, int[] b) {
    int[] c = new int[a.length + b.length];
    System.arraycopy(a, 0, c, 0, a.length);
    System.arraycopy(b, 0, c, a.length, b.length);
    return c;
  }
}
