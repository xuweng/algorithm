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
                if (index < s.length) {
                    if (s[index++] < j) {
                        break;
                    } else {
                        result++;
                    }
                }
            }
            return result;
        }
    }
}
