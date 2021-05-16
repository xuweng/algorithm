package com.leetcode.tag.contest.five;

import java.util.HashMap;
import java.util.Map;

/**
 * 5761. 找出和为指定值的下标对
 */
public class FindSumPairs {
    Map<Integer, Integer> map = new HashMap<>();
    int[] nums1, nums2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        for (int num : nums2) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        this.nums1 = nums1;
        this.nums2 = nums2;
    }

    public void add(int index, int val) {
        map.put(nums2[index], map.get(nums2[index]) - 1);
        nums2[index] += val;
        map.put(nums2[index], map.getOrDefault(nums2[index], 0) + 1);
    }

    public int count(int tot) {
        int count = 0;
        for (int j : nums1) {
            count += map.getOrDefault(tot - j, 0);
        }
        return count;
    }
}
