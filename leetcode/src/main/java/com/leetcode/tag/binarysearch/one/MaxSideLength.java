package com.leetcode.tag.binarysearch.one;

/**
 * 1292. 元素和小于等于阈值的正方形的最大边长
 * <p>
 * 经典题目.经典题目.经典题目.经典题目.
 */
public class MaxSideLength {
    /**
     * 解法一 前缀和
     * <p>
     * 作者：hlxing
     * 链接：https://leetcode-cn.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/solution/qing-xi-tu-jie-mo-neng-de-qian-zhui-he-by-hlxing/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int maxSideLength(int[][] mat, int threshold) {
            int m = mat.length, n = mat[0].length;
            //二维前缀和
            //引入二维前缀和的计算方法，通过预处理可以在 O(1) 时间内计算出一块区域内元素的总和
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = mat[i - 1][j - 1] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
                }
            }
            int ans = 0;
            for (int k = 1; k <= Math.min(m, n); k++) {
                for (int i = 1; i <= m; i++) {
                    for (int j = 1; j <= n; j++) {
                        if (i - k < 0 || j - k < 0) {
                            continue;
                        }
                        int tmp = dp[i][j] - dp[i - k][j] - dp[i][j - k] + dp[i - k][j - k];
                        if (tmp <= threshold) {
                            ans = Math.max(ans, k);
                        }
                    }
                }
            }
            return ans;
        }
    }

    class Solution1 {
        int m, n;
        int[][] dp;

        public int maxSideLength(int[][] mat, int threshold) {
            m = mat.length;
            n = mat[0].length;
            dp = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = mat[i - 1][j - 1] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
                }
            }
            // 坐标二分
            int l = 0, h = Math.min(m, n);
            while (l <= h) {
                int mid = l + (h - l) / 2;
                if (l == h || l + 1 == h) {
                    break;
                }
                if (help(mid, threshold)) {
                    l = mid;
                } else {
                    h = mid - 1;
                }
            }
            return help(h, threshold) ? h : l;
        }

        public boolean help(int k, int threshold) {
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i - k < 0 || j - k < 0) {
                        continue;
                    }
                    if (dp[i][j] - dp[i - k][j] - dp[i][j - k] + dp[i - k][j - k] <= threshold) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

}
