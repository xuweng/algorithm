package com.leetcode.tag.recursive;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 698. 划分为k个相等的子集
 */
public class s698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        Map<Integer, Integer> map = new ConcurrentHashMap<>();
        re(nums, nums.length - 1, map);

        AtomicBoolean result = new AtomicBoolean(false);
        map.forEach(
                (key, v) -> {
                    if (v == k) {
                        result.set(true);
                    }
                });

        return result.get();
    }

    private void re(int[] nums, int n, Map<Integer, Integer> map) {
        if (n <= 0) {
            map.put(nums[n], 1);
            return;
        }
        if (map.containsKey(nums[n])) {
            map.put(nums[n], map.get(nums[n]) + 1);
        }

        map.forEach(
                (k, v) -> {
                    if (k != nums[n]) {
                        map.put(nums[n] + k, 1);
                    }
                });
        if (!map.containsKey(nums[n])) {
            map.put(nums[n], 1);
        }
        re(nums, n - 1, map);
    }
}
