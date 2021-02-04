package com.leetcode.tag.must.one;

import java.util.Arrays;

/**
 * 279. 完全平方数
 */
public class NumSquares {
    class Solution {
        public int numSquares(int n) {
            int[] dp = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                dp[i] = i;
                for (int j = 1; j < i; j++) {
                    if (j * j <= i) {
                        dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                    }
                }
            }

            return dp[n];
        }
    }

    class Solution2 {
        public int numSquares(int n) {
            int[] minDp = new int[n + 1];
            minDp[1] = 1;
            for (int i = 2; i <= n; i++) {
                minDp[i] = Integer.MAX_VALUE;
                for (int j = 1; j * j <= i; j++) {
                    minDp[i] = Math.min(minDp[i], minDp[i - j * j] + 1);
                }
            }

            return minDp[n];
        }
    }

    /**
     * 方法二：动态规划
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/perfect-squares/solution/wan-quan-ping-fang-shu-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int numSquares(int n) {
            int[] dp = new int[n + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            // bottom case
            dp[0] = 0;

            // pre-calculate the square numbers.
            int maxSquareIndex = (int) Math.sqrt(n) + 1;
            int squareNums[] = new int[maxSquareIndex];
            for (int i = 1; i < maxSquareIndex; ++i) {
                squareNums[i] = i * i;
            }

            for (int i = 1; i <= n; ++i) {
                for (int s = 1; s < maxSquareIndex; ++s) {
                    if (i < squareNums[s]) {
                        break;
                    }
                    dp[i] = Math.min(dp[i], dp[i - squareNums[s]] + 1);
                }
            }
            return dp[n];
        }
    }

}
