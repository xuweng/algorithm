package com.leetcode.tag.contest.four;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

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
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        int count = 0;
        for (int i : nums1) {
            if (set2.contains(tot - i)) {
                count++;
            }
        }

        return count;
    }
}