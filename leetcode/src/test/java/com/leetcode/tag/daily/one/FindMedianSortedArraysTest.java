package com.leetcode.tag.daily.one;

import org.junit.Test;

public class FindMedianSortedArraysTest {
  @Test
  public void test() {
    FindMedianSortedArrays.Solution1 solution1 = new FindMedianSortedArrays.Solution1();
    int[] nums1 = new int[]{1, 3, 4, 5, 6};
    int[] nums2 = new int[]{2};

    solution1.findMedianSortedArrays(nums1, nums2);
  }
}
