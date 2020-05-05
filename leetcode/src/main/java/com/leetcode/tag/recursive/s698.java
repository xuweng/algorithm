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

    /**
     * 把树放入list
     *
     * <p>把整个树放入list;把左子树放入list;把右子树放入list
     *
     * <p>把前n放入map
     *
     * @param nums
     * @param n
     * @param map
     */
    private void re(int[] nums, int n, Map<Integer, Integer> map) {
        if (n <= 0) {
            map.put(nums[n], 1);
            return;
        }
        // 注意递归调用顺序.逻辑清晰
        // 递归处理子问题.先把前n-1放入map,再处理n
        re(nums, n - 1, map);
        // 处理n.知道哪里错误
        // 包含nums[n]如何计算?不包含nums[n]如何计算?
        map.forEach(
                (k, v) -> {
                    int key = nums[n] + k;
                    if (map.containsKey(key)) {
                        map.put(key, map.get(key) + 1);
                    } else {
                        map.put(key, 1);
                    }
                });
        if (map.containsKey(nums[n])) {
            map.put(nums[n], map.get(nums[n]) + 1);
        } else {
            map.put(nums[n], 1);
        }
    }
}
