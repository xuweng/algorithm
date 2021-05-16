package com.leetcode.tag.contest.four;

/**
 * 5761. 找出和为指定值的下标对
 */
public class FindSumPairs {
    int[] nums1;
    int[] nums2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
    }

    public void add(int index, int val) {
        nums2[index] += val;
    }

    public int count(int tot) {
        int count = 0;
        for (int i : nums1) {
            for (int j : nums2) {
                if (i + j == tot) {
                    count++;
                }
            }
        }

        return count;
    }
}