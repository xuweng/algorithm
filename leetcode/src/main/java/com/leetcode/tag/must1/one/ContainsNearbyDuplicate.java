package com.leetcode.tag.must1.one;

import java.util.HashMap;
import java.util.Map;

/**
 * 219. 存在重复元素 II
 * <p>
 * 快慢指针移动后才比较
 */
public class ContainsNearbyDuplicate {
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i]) && Math.abs(map.get(nums[i]) - i) <= k) {
                    return true;
                } else {
                    map.put(nums[i], i);
                }
            }

            return false;
        }
    }
}
