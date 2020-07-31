package com.leetcode.tag.daily;

/**
 * 面试题 08.03. 魔术索引
 */
public class FindMagicIndex {
    class Solution {
        public int findMagicIndex(int[] nums) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == i) {
                    return i;
                }
            }
            return -1;
        }
    }
}
