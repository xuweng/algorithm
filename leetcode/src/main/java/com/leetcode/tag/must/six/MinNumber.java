package com.leetcode.tag.must.six;

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
            // 拼接升序
            Arrays.sort(strings, (a, b) -> (a + b).compareTo(b + a));
            if (strings[0].charAt(0) == '0') {
                return "0";
            }

            return String.join("", strings);
        }
    }
}
