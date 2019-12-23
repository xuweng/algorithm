package com.algorithm.study.algorithm.dp;

/**
 * 最长的回文子串
 * <p>
 * 递归字符串模板
 * <p>
 * 最长-------最优解只有一个,即最优解唯一
 */
public class LongestPalindrome {
    /**
     * 递归最长的回文子串长度
     *
     * @param s
     * @param i 字符串下标
     * @param j 字符串下标
     * @return
     */
    public static int longestPalindromeRe(String s, int i, int j) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            return 1;
        }
        if (s.charAt(i) == s.charAt(j)) {
            return longestPalindromeRe(s, i + 1, j - 1) + 2;
        } else {
            return Math.max(longestPalindromeRe(s, i, j - 1), longestPalindromeRe(s, i + 1, j));
        }
    }
}
