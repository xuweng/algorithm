package com.leetcode.tag.must3.four;

import java.util.Arrays;

/**
 * 剑指 Offer 45. 把数组排成最小的数
 */
public class MinNumber {
    class Solution {
        public String minNumber(int[] nums) {
            if (nums == null || nums.length == 0) {
                return null;
            }
            String[] strings = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                strings[i] = String.valueOf(nums[i]);
            }
            // [10,2]-->[10,2]
            // [10,2] 102 210 取小102
            // 拼接升序
            Arrays.sort(strings, (a, b) -> (a + b).compareTo(b + a));

            return String.join("", strings);
        }
    }
}
