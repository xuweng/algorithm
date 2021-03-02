package com.leetcode.tag.dp.one.three;

import java.util.Arrays;

/**
 * 1547. 切棍子的最小成本
 * <p>
 * 本题和 312. 戳气球 较为相似，都是经典的区间动态规划题。
 * <p>
 * 类似石子合并问题、戳气球。
 * <p>
 * 区间动态规划
 * <p>
 * 模拟理解 模拟理解 模拟理解
 */
public class MinCost {
    /**
     * 模拟理解 理解题意
     * <p>
     * 方法一：动态规划
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/minimum-cost-to-cut-a-stick/solution/qie-gun-zi-de-zui-xiao-cheng-ben-by-leetcode-solut/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        /**
         * 我们用 f[i][j] 表示在当前待切割的木棍的左端点为 cuts[i−1]，右端点为 cuts[j+1] 时，将木棍全部切开的最小总成本。
         * <p>
         * 如果第一刀的位置为 cuts[k]，其中 k∈[i,j]，那么我们会将待切割的木棍分成两部分，左侧部分的木棍为 cuts[i−1..k]，
         * <p>
         * 对应的可以继续切割的位置为 cuts[i..k−1]；右侧部分的木棍为 cuts[k..j+1]，对应的可以继续切割的位置为 cuts[k+1..j]
         * <p>
         * 即我们无论在哪里切第一刀，这一刀的成本都是木棍的长度 cuts[j+1]−cuts[i−1]。
         * <p>
         * 作者：LeetCode-Solution
         * 链接：https://leetcode-cn.com/problems/minimum-cost-to-cut-a-stick/solution/qie-gun-zi-de-zui-xiao-cheng-ben-by-leetcode-solut/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         *
         * @param n
         * @param cuts
         * @return
         */
        public int minCost(int n, int[] cuts) {
            int m = cuts.length;
            Arrays.sort(cuts);
            //在左侧添加 0，右侧添加 n
            int[] newCuts = new int[m + 2];
            newCuts[0] = 0;
            for (int i = 1; i <= m; ++i) {
                newCuts[i] = cuts[i - 1];
            }
            newCuts[m + 1] = n;
            //我们用 f[i][j] 表示在当前待切割的木棍的左端点为 cuts[i−1]，右端点为 cuts[j+1] 时，将木棍全部切开的最小总成本。
            int[][] f = new int[m + 2][m + 2];
            // 区间dp遍历模板 对角线开始倒序遍历
            for (int i = m; i >= 1; --i) {
                for (int j = i; j <= m; ++j) {
                    //  较小值初始化 较大值初始化
                    f[i][j] = i == j ? 0 : Integer.MAX_VALUE;
                    for (int k = i; k <= j; ++k) {
                        f[i][j] = Math.min(f[i][j], f[i][k - 1] + f[k + 1][j]);
                    }
                    // 右端点 cuts[j+1]
                    // 左端点 cuts[i−1]
                    // 无论在哪里切第一刀，这一刀的成本都是木棍的长度 cuts[j+1]−cuts[i−1]
                    f[i][j] += newCuts[j + 1] - newCuts[i - 1];
                }
            }
            // 闭区间 不是开区间
            // 左端点为0 右端点为n
            return f[1][m];
        }
    }

}
