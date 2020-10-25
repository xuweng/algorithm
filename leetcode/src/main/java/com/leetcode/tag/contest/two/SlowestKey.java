package com.leetcode.tag.contest.two;

/**
 * 5546. 按键持续时间最长的键
 */
public class SlowestKey {
    class Solution {
        public char slowestKey(int[] releaseTimes, String keysPressed) {
            int[] ints = new int[26];
            ints[keysPressed.charAt(0) - 'a'] = releaseTimes[0];
            for (int i = 1; i < keysPressed.length(); i++) {
                ints[keysPressed.charAt(i) - 'a'] = releaseTimes[i] - releaseTimes[i - 1];
            }
            char c = 'a';
            int max = 0;
            for (int i = 0; i < ints.length; i++) {
                if (ints[i] >= max) {
                    c = (char) (i + 'a');
                    max = ints[i];
                }
            }
            return c;
        }
    }
}
