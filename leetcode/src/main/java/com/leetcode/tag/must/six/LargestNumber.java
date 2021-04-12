package com.leetcode.tag.must.six;

import java.util.Arrays;

/**
 * 179. 最大数
 */
public class LargestNumber {
    class Solution {
        public String largestNumber(int[] nums) {
            if (nums == null || nums.length == 0) {
                return "";
            }
            String[] strings = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                strings[i] = String.valueOf(nums[i]);
            }
            if (strings[0].charAt(0) == '0') {
                return "0";
            }
            // 拼接降序
            Arrays.sort(strings, (b, a) -> (b + a).compareTo(a + b));

            StringBuilder stringBuilder = new StringBuilder();
            for (int num : nums) {
                stringBuilder.append(num);
            }

            return stringBuilder.toString();
        }
    }
}
