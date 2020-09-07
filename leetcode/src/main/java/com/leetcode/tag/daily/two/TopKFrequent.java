package com.leetcode.tag.daily.two;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
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

            Set<Map.Entry<Integer, Integer>> entries = map.entrySet();

            List<Map.Entry<Integer, Integer>> collect = entries.stream()
                    .sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());

            int[] result = new int[k];
            int index = 0;
            for (int i = k; i < collect.size(); i++) {
                result[index++] = collect.get(i).getValue();
            }

            return result;
        }
    }
}
