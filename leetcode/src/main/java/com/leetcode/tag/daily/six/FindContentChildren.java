package com.leetcode.tag.daily.six;

import java.util.Arrays;

/**
 * 455. 分发饼干
 */
public class FindContentChildren {
    class Solution {
        public int findContentChildren(int[] g, int[] s) {
            if (g == null || g.length == 0 || s == null || s.length == 0) {
                return 0;
            }
            Arrays.sort(g);
            Arrays.sort(s);

            int result = 0;
            int index = 0;
            for (int j : g) {
                while (index < s.length) {
                    if (s[index] >= j) {
                        result++;
                        index++;
                        break;
                    }
                    index++;
                }
            }
            return result;
        }
    }
}
