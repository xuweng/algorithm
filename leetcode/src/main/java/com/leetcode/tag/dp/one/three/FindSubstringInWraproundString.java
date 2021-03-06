package com.leetcode.tag.dp.one.three;

import java.util.Arrays;

/**
 * 467. 环绕字符串中唯一的子字符串
 * <p>
 * 滑动窗口适合在题目要求连续的情况下使用， 而前缀和也是如此
 */
public class FindSubstringInWraproundString {
    /**
     * 测试用例 bcabc
     * <p>
     * 解法：动态规划
     * <p>
     * 只需求出 p 中以每个字符结尾的最长连续子串的长度即可
     * <p>
     * 作者：zyxwmj
     * 链接：https://leetcode-cn.com/problems/unique-substrings-in-wraparound-string/solution/dong-tai-gui-hua-java-by-zyxwmj-dn12/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int findSubstringInWraproundString(String p) {
            // 记录 p 中以每个字符结尾的最长连续子串的长度
            int[] dp = new int[26];
            char[] array = p.toCharArray();
            // 记录当前连续子串的长度
            int count = 0;
            // 遍历 p 中的所有字符
            for (int i = 0; i < array.length; i++) {
                // 判断字符是否连续 注意环形 za
                // b-a-1=1-1=0 c-b-1=1-1=0 a-z-1=1-26-1=-26
                if (i > 0 && (array[i] - array[i - 1] - 1) % 26 == 0) {
                    // 连续则自加
                    count++;
                } else {
                    // 不连续则刷新
                    count = 1;
                }
                // 只存储最长的连续长度
                dp[array[i] - 'a'] = Math.max(dp[array[i] - 'a'], count);
            }
            // 统计所有以每个字符结尾的最长连续子串的长度，就是唯一相等子串的个数
            return Arrays.stream(dp).sum();
        }
    }

    /**
     * 测试用例 栈 单调栈 内容 下标
     * <p>
     * 测试用例 "cdefghefghi"
     * <p>
     * 第一个h的最长长度是6 第二个h的最长长度Math.max(6,4)=6 正确是4
     * <p>
     * dp
     */
    class Solution1 {
        /**
         * 求和 最值 重复求和
         * <p>
         * 算法错误 重复计算
         *
         * @param p
         * @return
         */
        public int findSubstringInWraproundString(String p) {
            // 记录 p 中以每个字符结尾的最长连续子串的长度
            int[] dp = new int[p.length()];
            char[] array = p.toCharArray();
            // 遍历 p 中的所有字符
            for (int i = 0; i < array.length; i++) {
                dp[i] = 1;
                // 判断字符是否连续 注意环形 za
                // b-a-1=1-1=0 c-b-1=1-1=0 a-z-1=1-26-1=-26
                if (i > 0 && (array[i] - array[i - 1] - 1) % 26 == 0) {
                    // dp方程错误
                    // array[i - 1] - 'a'] 前一个字符和当前字符连续 前一个字符的最长连续字串的长度和当前字符不连续
                    dp[i] = dp[i - 1] + 1;
                }
            }
            // 统计所有以每个字符结尾的最长连续子串的长度，就是唯一相等子串的个数
            return Arrays.stream(dp).sum();
        }
    }
}
