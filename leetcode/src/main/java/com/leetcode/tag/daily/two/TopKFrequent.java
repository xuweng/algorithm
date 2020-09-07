package com.leetcode.tag.daily.two;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 347. 前 K 个高频元素
 */
public class TopKFrequent {
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return new int[0];
            }
            Map<Integer, Integer> map = new HashMap<>(64);
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            List<Map.Entry<Integer, Integer>> collect = map.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());

            int[] result = new int[k];
            int index = 0;
            int count = 0;
            for (int i = collect.size() - 1; count < k; i--, count++) {
                result[index++] = collect.get(i).getKey();
            }

            return result;
        }
    }
}
