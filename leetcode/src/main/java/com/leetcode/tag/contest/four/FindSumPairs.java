package com.leetcode.tag.contest.four;

import java.util.HashMap;
import java.util.Map;

/**
 * 5761. 找出和为指定值的下标对
 */
public class FindSumPairs {
    int[] nums1;
    int[] nums2;
    Map<Integer, Integer> map;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        map = new HashMap<>();
        for (int i : nums2) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
    }

    public void add(int index, int val) {
        map.put(nums2[index], map.getOrDefault(nums2[index], 1) - 1);
        nums2[index] += val;
        map.put(nums2[index], map.getOrDefault(nums2[index], 0) + 1);
    }

    public int count(int tot) {
        int count = 0;
        for (int i : nums1) {
            if (map.containsKey(tot - i)) {
                count += map.get(tot - i);
            }
        }

        return count;
    }
}