package com.leetcode.tag.dfs.one;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 16.19. 水域大小
 * <p>
 * 回溯.树.dfs.都是递归.
 */
public class PondSizes {
    class Solution {
        //上下左右.左上右上左下右下
        int[] row = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] col = {0, 0, -1, 1, -1, 1, -1, 1};

        boolean[][] usedBack;
        boolean[][] used;
        int count;

        public int[] pondSizes(int[][] land) {
            usedBack = new boolean[land.length][land[0].length];
            used = new boolean[land.length][land[0].length];

            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < land.length; i++) {
                for (int i1 = 0; i1 < land[0].length; i1++) {
                    if (land[i][i1] == 0 && !used[i][i1]) {
                        dfs(land, i, i1, 0);
                        result.add(count + 1);
                        count = 0;
                    }
                }
            }

            return result.stream().mapToInt(Integer::intValue).toArray();
        }

        public void dfs(int[][] land, int r, int c, int sum) {
            if (r < 0 || r >= land.length || c < 0 || c >= land[0].length || land[r][c] != 0) {
                count += sum;
                return;
            }
            used[r][c] = true;
            for (int i = 0; i < row.length; i++) {
                if (usedBack[r][c]) {
                    continue;
                }
                usedBack[r][c] = true;
                dfs(land, r + row[i], c + col[i], sum + 1);
                usedBack[r][c] = false;
            }
        }
    }
}
