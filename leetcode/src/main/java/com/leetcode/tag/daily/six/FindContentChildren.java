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

    /**
     * 方法一：排序 + 贪心算法
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/assign-cookies/solution/fen-fa-bing-gan-by-leetcode-solution-50se/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);
            int numOfChildren = g.length, numOfCookies = s.length;
            int count = 0;
            for (int i = 0, j = 0; i < numOfChildren && j < numOfCookies; i++, j++) {
                while (j < numOfCookies && g[i] > s[j]) {
                    j++;
                }
                if (j < numOfCookies) {
                    count++;
                }
            }
            return count;
        }
    }

}
