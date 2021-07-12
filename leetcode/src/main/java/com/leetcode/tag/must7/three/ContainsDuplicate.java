package com.leetcode.tag.must7.three;

import java.util.HashMap;
import java.util.Map;

/**
 * 217. 存在重复元素
 */
public class ContainsDuplicate {
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0));
                if (map.get(num) > 1) {
                    return true;
                }
            }

            return false;
        }
    }
}
