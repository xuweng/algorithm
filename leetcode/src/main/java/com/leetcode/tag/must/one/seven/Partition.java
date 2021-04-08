package com.leetcode.tag.must.one.seven;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 131. 分割回文串
 */
public class Partition {
    class Solution {
        List<List<String>> result = new ArrayList<>();
        List<String> stack = new ArrayList<>();

        public List<List<String>> partition(String s) {
            if (s == null || s.isEmpty()) {
                return result;
            }

            dfs(s, 0);

            return result;
        }

        private void dfs(String s, int index) {
            if (index >= s.length()) {
                result.add(new ArrayList<>(stack));
                return;
            }
            for (int i = index; i < s.length(); i++) {
                if (!is(s, index, i)) {
                    continue;
                }
                stack.add(s.substring(index, i + 1));
                dfs(s, i + 1);
                stack.remove(stack.size() - 1);
            }
        }

        private boolean is(String s, int i, int j) {
            while (i <= j) {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }
                i++;
                j--;
            }

            return true;
        }
    }

    class Solution2 {
        List<List<String>> result = new ArrayList<>();
        List<String> stack = new ArrayList<>();
        boolean[][] dp;

        public List<List<String>> partition(String s) {
            if (s == null || s.isEmpty()) {
                return result;
            }
            dp = new boolean[s.length()][s.length()];
            for (int i = 0; i < s.length(); i++) {
                dp[i][i] = true;
            }
            for (int i = s.length() - 2; i >= 0; i--) {
                for (int j = i + 1; j < s.length(); j++) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                    if (j > i + 1) {
                        dp[i][j] = dp[i][j] && dp[i + 1][j - 1];
                    }
                }
            }

            dfs(s, 0);

            return result;
        }

        private void dfs(String s, int index) {
            if (index >= s.length()) {
                result.add(new ArrayList<>(stack));
                return;
            }
            for (int i = index; i < s.length(); i++) {
                if (!dp[index][i]) {
                    continue;
                }
                stack.add(s.substring(index, i + 1));
                dfs(s, i + 1);
                stack.remove(stack.size() - 1);
            }
        }

        private boolean is(String s, int i, int j) {
            while (i <= j) {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }
                i++;
                j--;
            }

            return true;
        }
    }

    /**
     * 方法一：回溯 + 动态规划预处理
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/palindrome-partitioning/solution/fen-ge-hui-wen-chuan-by-leetcode-solutio-6jkv/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        boolean[][] f;
        List<List<String>> ret = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        int n;

        public List<List<String>> partition(String s) {
            n = s.length();
            f = new boolean[n][n];
            for (int i = 0; i < n; ++i) {
                Arrays.fill(f[i], true);
            }

            for (int i = n - 1; i >= 0; --i) {
                for (int j = i + 1; j < n; ++j) {
                    f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
                }
            }

            dfs(s, 0);
            return ret;
        }

        public void dfs(String s, int i) {
            if (i == n) {
                ret.add(new ArrayList<>(ans));
                return;
            }
            for (int j = i; j < n; ++j) {
                if (!f[i][j]) {
                    continue;
                }
                ans.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }

}
