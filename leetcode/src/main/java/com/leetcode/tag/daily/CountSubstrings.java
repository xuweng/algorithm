package com.leetcode.tag.daily;

import java.util.Arrays;

/**
 * 647. 回文子串
 */
public class CountSubstrings {
    class Solution {
        public int countSubstrings(String s) {
            return 0;
        }
    }

    /**
     * 计算有多少个回文子串的最朴素方法就是枚举出所有的回文子串，而枚举出所有的回文字串又有两种思路，分别是：
     * <p>
     * 枚举出所有的子串，然后再判断这些子串是否是回文；
     * 枚举每一个可能的回文中心，然后用两个指针分别向左右两边拓展，当两个指针指向的元素相同的时候就拓展，否则停止拓展。
     * <p>
     * 方法一：中心拓展
     * <p>
     * 时间复杂度：O(n^2)
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/palindromic-substrings/solution/hui-wen-zi-chuan-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int countSubstrings(String s) {
            int n = s.length(), ans = 0;
            for (int i = 0; i < 2 * n - 1; ++i) {
                int l = i / 2, r = i / 2 + i % 2;
                while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                    --l;
                    ++r;
                    ++ans;
                }
            }
            return ans;
        }
    }

    class Solution2 {
        public int countSubstrings(String s) {
            int n = s.length();
            boolean[][] dp = new boolean[n][n];
            int count = 0;
            for (int j = 0; j < n; j++) {
                for (int i = 0; i <= j; i++) {
                    if (s.charAt(j) == s.charAt(i)) {
                        if (dp[i][j] = i == j || j - i == 1 || dp[i + 1][j - 1]) {
                            count++;
                        }
                    }
                }
            }
            return count;
        }
    }

    /**
     * 作者：acw_weian
     * 链接：https://leetcode-cn.com/problems/palindromic-substrings/solution/647-hui-wen-zi-chuan-qu-jian-dp-shi-jian-fu-za-du-/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution3 {
        /**
         * 我们罗列一下dp[i][j]为 true 的情形：
         * <p>
         * 由单个字符组成。
         * 由 2 个字符组成，且字符要相同。(单独拿出来防止dp[i+1][j-1]越界)
         * 由多于 2 个字符组成，首尾字符相同，且剩余子串是一个回文串。
         * <p>
         * dp[i][j]:字符串从i到j是否为回文串
         * <p>
         * s[i]!=s[j],dp[i][j]=false
         * s[i]=s[j],dp[i][j]=dp[i+1][j-1]
         *
         * @param s
         * @return
         */
        public int countSubstrings(String s) {
            int ans = 0, n = s.length(), j;
            char[] cs = s.toCharArray();
            boolean[][] dp = new boolean[n][n];
            for (int len = 1; len <= n; len++) {
                for (int i = 0; i + len - 1 < n; i++) {
                    j = i + len - 1;
                    if (len == 1) {
                        dp[i][j] = true;
                        ans++;
                    } else {
                        if (cs[i] == cs[j]) {
                            dp[i][j] = (len == 2 || dp[i + 1][j - 1]);
                            if (dp[i][j]) {
                                ans++;
                            }
                        }
                    }
                }
            }
            return ans;
        }
    }

    class Solution4 {
        /**
         * 我们罗列一下dp[i][j]为 true 的情形：
         * <p>
         * 由单个字符组成。
         * 由 2 个字符组成，且字符要相同。(单独拿出来防止dp[i+1][j-1]越界)
         * 由多于 2 个字符组成，首尾字符相同，且剩余子串是一个回文串。
         * <p>
         * dp[i][j]:字符串从i到j是否为回文串
         * <p>
         * s[i]!=s[j],dp[i][j]=false
         * s[i]=s[j],dp[i][j]=dp[i+1][j-1]
         *
         * @param s
         * @return
         */
        public int countSubstrings(String s) {
            int count = 0;
            int len = s.length();

            boolean[][] dp = new boolean[len][len];
            for (boolean[] booleans : dp) {
                Arrays.fill(booleans, false);
            }

            // i<=j
            //计算顺序。这个很重要。
            //先枚举j，再枚举i。枚举状态的顺序。
            for (int j = 0; j < len; j++) {
                // i<=j
                for (int i = 0; i <= j; i++) {
                    if (i == j) { // 单个字符
                        dp[i][j] = true;
                        count++;
                    } else if (j - i == 1 && s.charAt(i) == s.charAt(j)) { // 两个字符
                        dp[i][j] = true;
                        count++;
                    } else if (j - i > 1 && s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) { // 多于两个字符
                        dp[i][j] = true;
                        count++;
                    }
                }
            }
            return count;
        }
    }
}
