package com.leetcode.tag.slidingwindow;

/**
 * 718. 最长重复子数组
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
            int n = A.length;
            int m = B.length;
            int[][] dp = new int[n + 1][m + 1]; // dp[i][j]表示A的前i项与B的前j项的最长重复子数组长度
            int ans = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (A[i - 1] == B[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    ans = Math.max(ans, dp[i][j]);
                }
            }
            return ans;
        }
    }

    /**
     * 滚动数组
     */
    class Solution1 {
        /**
         * 子数组 不是子序列
         *
         * @param A
         * @param B
         * @return
         */
        public int findLength(int[] A, int[] B) {
            int n = A.length;
            int m = B.length;
            int[] dp = new int[m + 1];
            int ans = 0;
            for (int i = 1; i <= n; i++) {
                // 倒序遍历
                for (int j = m; j >= 1; j--) {
                    if (A[i - 1] == B[j - 1]) {
                        dp[j] = dp[j - 1] + 1;
                    } else {
                        // 必须置0
                        dp[j] = 0;
                    }
                    ans = Math.max(ans, dp[j]);
                }
            }
            return ans;
        }
    }

    /**
     * 方法二：滑动窗口
     * <p>
     * 枚举 A 和 B 所有的对齐方式。
     * <p>
     * 对齐的方式有两类：第一类为 A 不变，B 的首元素与 A 中的某个元素对齐；
     * <p>
     * 第二类为 B 不变，A 的首元素与 B 中的某个元素对齐
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/solution/zui-chang-zhong-fu-zi-shu-zu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/solution/zui-chang-zhong-fu-zi-shu-zu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public int findLength(int[] A, int[] B) {
            int n = A.length, m = B.length;
            int ret = 0;
            //第一类为 A 不变，B 的首元素与 A 中的某个元素对齐
            for (int i = 0; i < n; i++) {
                int len = Math.min(m, n - i);
                int maxlen = maxLength(A, B, i, 0, len);
                ret = Math.max(ret, maxlen);
            }
            //第二类为 B 不变，A 的首元素与 B 中的某个元素对齐
            for (int i = 0; i < m; i++) {
                int len = Math.min(n, m - i);
                int maxlen = maxLength(A, B, 0, i, len);
                ret = Math.max(ret, maxlen);
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
