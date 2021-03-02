package com.leetcode.tag.dp.one.three;

import java.util.Arrays;

/**
 * 1547. 切棍子的最小成本
 * <p>
 * 本题和 312. 戳气球 较为相似，都是经典的区间动态规划题。
 * <p>
 * 区间动态规划
 * <p>
 * 模拟理解 模拟理解 模拟理解
 */
public class MinCost {
    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/minimum-cost-to-cut-a-stick/solution/qie-gun-zi-de-zui-xiao-cheng-ben-by-leetcode-solut/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int minCost(int n, int[] cuts) {
            int m = cuts.length;
            Arrays.sort(cuts);
            int[] newCuts = new int[m + 2];
            newCuts[0] = 0;
            for (int i = 1; i <= m; ++i) {
                newCuts[i] = cuts[i - 1];
            }
            newCuts[m + 1] = n;
            int[][] f = new int[m + 2][m + 2];
            for (int i = m; i >= 1; --i) {
                for (int j = i; j <= m; ++j) {
                    //  较小值初始化 较大值初始化
                    f[i][j] = i == j ? 0 : Integer.MAX_VALUE;
                    for (int k = i; k <= j; ++k) {
                        f[i][j] = Math.min(f[i][j], f[i][k - 1] + f[k + 1][j]);
                    }
                    f[i][j] += newCuts[j + 1] - newCuts[i - 1];
                }
            }
            // 闭区间 不是开区间
            return f[1][m];
        }
    }

}
