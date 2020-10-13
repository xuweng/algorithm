package com.leetcode.tag.dfs.one;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 756. 金字塔转换矩阵
 */
public class PyramidTransition {
    /**
     * 方法一：状态转换
     * <p>
     * 状态压缩
     * 1. 只有7个字母 {'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 可以使用一个字节来表示每个字母
     * 00000001 => 'A'
     * 00000010 => 'B'
     * 00000100 => 'C'
     * 00001000 => 'D'
     * 00010000 => 'E'
     * 00100000 => 'F'
     * 01000000 => 'G'
     * <p>
     * 作者：little-von
     * 链接：https://leetcode-cn.com/problems/pyramid-transition-matrix/solution/cyu-yan-zhuang-tai-ya-suo-wei-yun-suan-by-little-v/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
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

    /**
     * 方法二：深度优先搜索
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/pyramid-transition-matrix/solution/jin-zi-ta-zhuan-huan-ju-zhen-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        int[][] dp;
        Set<Long> seen;

        public boolean pyramidTransition(String bottom, List<String> allowed) {
            dp = new int[7][7];
            for (String a : allowed) {
                dp[a.charAt(0) - 'a'][a.charAt(1) - 'a'] |= 1 << (a.charAt(2) - 'a');
            }

            seen = new HashSet<>();
            int n = bottom.length();
            int[][] a = new int[n][n];
            int t = 0;
            for (char c : bottom.toCharArray()) {
                a[n - 1][t++] = c - 'a';
            }
            return solve(a, 0, n - 1, 0);
        }

        //a[i] - the ith row of the pyramid
        //r - integer representing the current row of the pyramid
        //n - length of current row we are calculating
        //i - index of how far in the current row we are calculating
        //Returns true iff pyramid can be built
        public boolean solve(int[][] a, long r, int n, int i) {
            if (n == 1 && i == 1) { // If successfully placed entire pyramid
                return true;
            } else if (i == n) {
                if (seen.contains(r)) {
                    return false; // If we've already tried this row, give up
                }
                seen.add(r); // Add row to cache
                return solve(a, 0, n - 1, 0); // Calculate next row
            } else {
                // w's jth bit is true iff block #j could be
                // a parent of a[n][i] and a[n][i+1]
                int w = dp[a[n][i]][a[n][i + 1]];
                // for each set bit in w...
                for (int b = 0; b < 7; ++b) {
                    if (((w >> b) & 1) != 0) {
                        a[n - 1][i] = b; //set parent to be equal to block #b
                        //If rest of pyramid can be built, return true
                        //r represents current row, now with ith bit set to b+1
                        // in base 8.
                        if (solve(a, r * 8 + (b + 1), n, i + 1)) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }
    }

}
