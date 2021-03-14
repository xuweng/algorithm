package com.leetcode.tag.contest.two;

import java.util.Objects;

/**
 * 5701. 仅执行一次字符串交换能否使两个字符串相等
 */
public class AreAlmostEqual {
    class Solution {
        public boolean areAlmostEqual(String s1, String s2) {
            if (Objects.equals(s1, s2)) {
                return true;
            }
            int count = 0;
            int index = -1;
            int index1 = -1;
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    count++;
                    index = index == -1 ? i : index;
                    index1 = i;
                }
            }

            return count == 2 && s1.charAt(index) == s2.charAt(index1) && s1.charAt(index1) == s2.charAt(index);
        }
    }
}
