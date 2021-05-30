package com.leetcode.tag.must5.five;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为K的子数组
 */
public class SubarraySum {
    class Solution {
        public int subarraySum(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);

            int count = 0;
            int sum = 0;
            for (int num : nums) {
                sum += num;
                if (map.containsKey(sum - k)) {
                    count += map.get(sum - k);
                }
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }

            return count;
        }
    }
}
