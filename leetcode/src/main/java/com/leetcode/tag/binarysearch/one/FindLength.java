package com.leetcode.tag.binarysearch.one;

/**
 * 718. 最长重复子数组
 * <p>
 * 数据结构.数据结构.数据结构.
 * <p>
 * 数据结构增删改查.数据结构增删改查.
 */
public class FindLength {
    /**
     * 方法一：动态规划
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/solution/zui-chang-zhong-fu-zi-shu-zu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int findLength(int[] A, int[] B) {
            int n = A.length, m = B.length;
            //dp[i][j] 表示 A[i:] 和 B[j:] 的最长公共前缀
            //如果 A[i] == B[j]，那么 dp[i][j] = dp[i + 1][j + 1] + 1，否则 dp[i][j] = 0。
            int[][] dp = new int[n + 1][m + 1];
            dp[n][m] = 0;
            int ans = 0;
            for (int i = n - 1; i >= 0; i--) {
                for (int j = m - 1; j >= 0; j--) {
                    dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : 0;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
            return ans;
        }
    }

    /**
     * 方法二：滑动窗口
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/solution/zui-chang-zhong-fu-zi-shu-zu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int findLength(int[] A, int[] B) {
            int n = A.length, m = B.length;
            int ret = 0;
            //枚举 A 和 B 所有的对齐方式

            //第一类为 A 不变，B 的首元素与 A 中的某个元素对齐
            for (int i = 0; i < n; i++) {
                int len = Math.min(m, n - i);
                int maxLen = maxLength(A, B, i, 0, len);
                ret = Math.max(ret, maxLen);
            }
            //第二类为 B 不变，A 的首元素与 B 中的某个元素对齐
            for (int i = 0; i < m; i++) {
                int len = Math.min(n, m - i);
                int maxLen = maxLength(A, B, 0, i, len);
                ret = Math.max(ret, maxLen);
            }
            return ret;
        }

        public int maxLength(int[] A, int[] B, int addA, int addB, int len) {
            int ret = 0, k = 0;
            for (int i = 0; i < len; i++) {
                if (A[addA + i] == B[addB + i]) {
                    k++;
                } else {
                    k = 0;
                }
                ret = Math.max(ret, k);
            }
            return ret;
        }
    }

}
