package com.leetcode.tag.daily.six;

import java.util.HashMap;
import java.util.Map;

/**
 * 217. 存在重复元素
 */
public class ContainsDuplicate {
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            if (nums == null || nums.length == 0) {
                return false;
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                if (map.get(num) > 1) {
                    return true;
                }
            }

            return false;
        }
    }
}
