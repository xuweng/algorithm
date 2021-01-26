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
        /**
         * pre[i][k] 表示在字符串前 i 个字符中，第 k 个元音字母一共出现的次数
         * <p>
         * dp[pattern] 的作用是用来记录当前索引值下对应的元音奇偶次数组合特征
         * <p>
         * 定义特征，aeiou 分别对应二进制 00001，00010，00100，01000，10000
         * 其中 0 表示对应元音出现了偶数次数，1 表示奇数
         * <p>
         * pattern 为 10，也就是对应二进制 01010，dp[pattern] = 8 的意思为，
         * 当索引值为 8 的时候，e 和 o 都出现了奇数次，其它元音为偶数次。
         * <p>
         * 作者：will_never_die
         * 链接：https://leetcode-cn.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/solution/xiang-xi-jie-shi-by-will_never_die/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         *
         * @param s
         * @return
         */
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
