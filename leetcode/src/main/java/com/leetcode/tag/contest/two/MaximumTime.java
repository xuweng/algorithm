package com.leetcode.tag.contest.two;

/**
 * 5661. 替换隐藏数字得到的最晚时间
 */
public class MaximumTime {
    class Solution {
        public String maximumTime(String time) {
            if (time == null || time.isEmpty()) {
                return time;
            }
            char[] chars = time.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != '?') {
                    continue;
                }
                if (i == 0) {
                    if (chars[i + 1] >= '4' && chars[i + 1] != '?') {
                        chars[i] = '1';
                    } else {
                        chars[i] = '2';
                    }
                } else if (i == 1) {
                    if (chars[i - 1] >= '2') {
                        chars[i] = '3';
                    } else {
                        chars[i] = '9';
                    }
                } else if (i == 3) {
                    chars[i] = '5';
                } else {
                    chars[i] = '9';
                }
            }

            return new String(chars);
        }
    }
}
