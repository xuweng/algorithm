package com.leetcode.tag.dfs.one;

import java.util.List;

/**
 * 756. 金字塔转换矩阵
 */
public class PyramidTransition {
    /**
     * 方法一：状态转换
     * <p>
     * 每个状态都是一个二进制数，如果第 k 类型的方块是可能的，则设置第 k 位
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/pyramid-transition-matrix/solution/jin-zi-ta-zhuan-huan-ju-zhen-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public boolean pyramidTransition(String bottom, List<String> allowed) {
            int[][] dp = new int[1 << 7][1 << 7];
            for (String triple : allowed) {
                int u = 1 << (triple.charAt(0) - 'A');
                int v = 1 << (triple.charAt(1) - 'A');
                int w = 1 << (triple.charAt(2) - 'A');
                for (int b1 = 0; b1 < (1 << 7); ++b1) {
                    if ((u & b1) > 0) {
                        for (int b2 = 0; b2 < (1 << 7); ++b2) {
                            if ((v & b2) > 0) {
                                dp[b1][b2] |= w;
                            }
                        }
                    }
                }
            }

            int[] state = new int[bottom.length()];
            int index = 0;
            for (char c : bottom.toCharArray()) {
                state[index++] = 1 << (c - 'A');
            }
            while (index-- > 1) {
                for (int i = 0; i < index; ++i) {
                    state[i] = dp[state[i]][state[i + 1]];
                }
            }
            return state[0] > 0;
        }
    }

}
