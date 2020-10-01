package com.leetcode.tag.daily.three;

/**
 * LCP 19. 秋叶收藏集
 * <p>
 * 搞懂题意.搞懂题意.搞懂题意.搞懂题意.搞懂题意.
 */
public class MinimumOperations {
    /**
     * 方法一：动态规划
     * <p>
     * 状态定义厉害
     * <p>
     * 我们用 f[i][j] 表示对于第 0 片到第 i 片叶子（记为 leaves[0..i]）进行调整操作，并且第 i 片叶子处于状态 j 时的最小操作次数
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/UlBDOe/solution/qiu-xie-shou-cang-ji-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int minimumOperations(String leaves) {
            int n = leaves.length();
            int[][] f = new int[n][3];
            f[0][0] = leaves.charAt(0) == 'y' ? 1 : 0;
            f[0][1] = f[0][2] = f[1][2] = Integer.MAX_VALUE;
            for (int i = 1; i < n; ++i) {
                int isRed = leaves.charAt(i) == 'r' ? 1 : 0;
                int isYellow = leaves.charAt(i) == 'y' ? 1 : 0;
                f[i][0] = f[i - 1][0] + isYellow;
                f[i][1] = Math.min(f[i - 1][0], f[i - 1][1]) + isRed;
                if (i >= 2) {
                    f[i][2] = Math.min(f[i - 1][1], f[i - 1][2]) + isYellow;
                }
            }
            return f[n - 1][2];
        }
    }

    /**
     * 方法二：前缀和 + 动态规划
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/UlBDOe/solution/qiu-xie-shou-cang-ji-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int minimumOperations(String leaves) {
            int n = leaves.length();
            int g = leaves.charAt(0) == 'y' ? 1 : -1;
            int gmin = g;
            int ans = Integer.MAX_VALUE;
            for (int i = 1; i < n; ++i) {
                int isYellow = leaves.charAt(i) == 'y' ? 1 : 0;
                g += 2 * isYellow - 1;
                if (i != n - 1) {
                    ans = Math.min(ans, gmin - g);
                }
                gmin = Math.min(gmin, g);
            }
            return ans + (g + n) / 2;
        }
    }
}
