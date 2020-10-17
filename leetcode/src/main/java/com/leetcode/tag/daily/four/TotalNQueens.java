package com.leetcode.tag.daily.four;

import java.util.HashSet;
import java.util.Set;

/**
 * 52. N皇后 II
 */
public class TotalNQueens {
    class Solution {
        int result;
        boolean[] cols;
        boolean[] lefts;
        boolean[] rights;

        public int totalNQueens(int n) {
            cols = new boolean[n];
            lefts = new boolean[2 * n];
            rights = new boolean[2 * n];

            dfs(n, 0);
            return result;
        }

        private void dfs(int n, int row) {
            if (row == n) {
                result++;
                return;
            }
            for (int i = 0; i < n; i++) {
                if (cols[i] || lefts[row + i] || rights[n - i + row]) {
                    continue;
                }
                cols[i] = true;
                //左上为原点
                lefts[row + i] = true;
                //右上为原点
                rights[n - i + row] = true;

                dfs(n, row + 1);

                cols[i] = false;
                lefts[row + i] = false;
                rights[n - i + row] = false;
            }
        }
    }

    /**
     * 方法一：基于集合的回溯
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/n-queens-ii/solution/nhuang-hou-ii-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int totalNQueens(int n) {
            Set<Integer> columns = new HashSet<>();
            Set<Integer> diagonals1 = new HashSet<>();
            Set<Integer> diagonals2 = new HashSet<>();
            return backtrack(n, 0, columns, diagonals1, diagonals2);
        }

        public int backtrack(int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
            if (row == n) {
                return 1;
            } else {
                int count = 0;
                for (int i = 0; i < n; i++) {
                    if (columns.contains(i)) {
                        continue;
                    }
                    //用set处理负数
                    int diagonal1 = row - i;
                    if (diagonals1.contains(diagonal1)) {
                        continue;
                    }
                    int diagonal2 = row + i;
                    if (diagonals2.contains(diagonal2)) {
                        continue;
                    }
                    columns.add(i);
                    diagonals1.add(diagonal1);
                    diagonals2.add(diagonal2);
                    count += backtrack(n, row + 1, columns, diagonals1, diagonals2);
                    columns.remove(i);
                    diagonals1.remove(diagonal1);
                    diagonals2.remove(diagonal2);
                }
                return count;
            }
        }
    }

}
