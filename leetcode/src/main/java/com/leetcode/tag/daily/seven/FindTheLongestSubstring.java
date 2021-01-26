package com.leetcode.tag.daily.seven;

import java.util.Arrays;

/**
 * 1371. 每个元音包含偶数次的最长子字符串
 * <p>
 * 各种解法 各种解法 各种解法
 */
public class FindTheLongestSubstring {
    /**
     * 方法一：前缀和 + 状态压缩
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/solution/mei-ge-yuan-yin-bao-han-ou-shu-ci-de-zui-chang-z-2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int findTheLongestSubstring(String s) {
            int n = s.length();
            int[] pos = new int[1 << 5];
            Arrays.fill(pos, -1);
            int ans = 0, status = 0;
            pos[0] = 0;
            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                if (ch == 'a') {
                    status ^= (1);
                } else if (ch == 'e') {
                    status ^= (1 << 1);
                } else if (ch == 'i') {
                    status ^= (1 << 2);
                } else if (ch == 'o') {
                    status ^= (1 << 3);
                } else if (ch == 'u') {
                    status ^= (1 << 4);
                }
                if (pos[status] >= 0) {
                    ans = Math.max(ans, i + 1 - pos[status]);
                } else {
                    pos[status] = i + 1;
                }
            }
            return ans;
        }
    }

}
