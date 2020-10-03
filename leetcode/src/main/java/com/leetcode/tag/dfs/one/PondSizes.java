package com.leetcode.tag.dfs.one;

import java.util.ArrayList;
import java.util.Arrays;
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

        boolean[][] used;
        int count;

        public int[] pondSizes(int[][] land) {
            used = new boolean[land.length][land[0].length];

            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < land.length; i++) {
                for (int i1 = 0; i1 < land[0].length; i1++) {
                    if (land[i][i1] == 0 && !used[i][i1]) {
                        dfs(land, i, i1);
                        result.add(count);
                        count = 0;
                    }
                }
            }

            return result.stream().sorted().mapToInt(Integer::intValue).toArray();
        }

        public void dfs(int[][] land, int r, int c) {
            if (r < 0 || r >= land.length || c < 0 || c >= land[0].length || land[r][c] != 0 || used[r][c]) {
                return;
            }
            count++;

            used[r][c] = true;
            for (int i = 0; i < row.length; i++) {
                dfs(land, r + row[i], c + col[i]);
            }
        }
    }

    /**
     * 深度遍历，八个方向进行搜索
     * <p>
     * 作者：ggeorge500
     * 链接：https://leetcode-cn.com/problems/pond-sizes-lcci/solution/java-dfsqiu-jie-chi-tang-mian-ji-by-ggeorge500/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int[] pondSizes(int[][] land) {
            List<Integer> list = new ArrayList<>();
            int temp;

            // 遍历矩阵每个元素
            for (int i = 0; i < land.length; i++) {
                for (int j = 0; j < land[0].length; j++) {
                    temp = findPool(land, i, j);
                    if (temp != 0) {
                        list.add(temp);
                    }
                }
            }

            // 第一种List<Integer>转int[]
            // int[] result = new int[list.size()];
            // for (int i = 0; i < result.length; i++) {
            //   result[i] = list.get(i);
            // }

            // 第二种List<Integer>转int[]，优雅且高效
            int[] result = list.stream().mapToInt(Integer::valueOf).toArray();

            Arrays.sort(result);

            return result;
        }

        private int findPool(int[][] land, int x, int y) {
            int num = 0;
            if (x < 0 || x >= land.length || y < 0 || y >= land[0].length || land[x][y] != 0) {
                return num;
            }
            num++;
            // 修改原数组
            // 如果为0，就转换为-1，避免重复搜索
            land[x][y] = -1;

            num += findPool(land, x + 1, y);
            num += findPool(land, x - 1, y);
            num += findPool(land, x, y + 1);
            num += findPool(land, x, y - 1);
            num += findPool(land, x + 1, y + 1);
            num += findPool(land, x + 1, y - 1);
            num += findPool(land, x - 1, y + 1);
            num += findPool(land, x - 1, y - 1);

            return num;
        }
    }

    class Solution2 {
        public int[] pondSizes(int[][] land) {
            int count;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < land.length; i++) {
                for (int j = 0; j < land[0].length; j++) {
                    if (land[i][j] == 0) {
                        count = dfs(land, i, j);
                        list.add(count);
                    }
                }
            }
            int[] res = list.stream().mapToInt(integer -> integer).toArray();
            Arrays.sort(res);
            return res;
        }

        private int dfs(int[][] land, int i, int j) {
            if (i < 0 || i >= land.length || j < 0 || j >= land[0].length || land[i][j] != 0) {
                return 0;
            }
            land[i][j] = -1;
            int count = 1;
            count += dfs(land, i, j - 1);
            count += dfs(land, i, j + 1);
            count += dfs(land, i + 1, j);
            count += dfs(land, i - 1, j);
            count += dfs(land, i + 1, j + 1);
            count += dfs(land, i - 1, j - 1);
            count += dfs(land, i + 1, j - 1);
            count += dfs(land, i - 1, j + 1);
            return count;
        }

    }

}
