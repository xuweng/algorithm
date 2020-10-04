package com.leetcode.tag.dfs.one;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 547. 朋友圈.
 * <p>
 * 搞懂题意.
 * <p>
 * 无向图.搞懂题意.
 * <p>
 * 邻接矩阵
 */
public class FindCircleNum {
    class Solution {
        int[] r = {-1, 1, 0, 0};
        int[] c = {0, 0, -1, 1};
        boolean[][] used;

        public int findCircleNum(int[][] M) {
            used = new boolean[M.length][M[0].length];
            int result = 0;
            for (int i = 0; i < M.length; i++) {
                for (int i1 = 0; i1 < M[0].length; i1++) {
                    if (M[i][i1] == 1 && !used[i][i1]) {
                        int count = dfs(M, i, i1);
                        if (count > 1) {
                            result++;
                        }
                    }
                }
            }

            return result;
        }

        private int dfs(int[][] M, int row, int col) {
            if (row < 0 || row >= M.length || col < 0 || col >= M[0].length || M[row][col] == 0 || used[row][col]) {
                return 0;
            }
            used[row][col] = true;
            int count = 1;
            for (int i = 0; i < r.length; i++) {
                count += dfs(M, row + r[i], col + c[i]);
            }
            return count;
        }
    }

    /**
     * 方法 1：深度优先搜索
     * <p>
     * 把 M 看成图的邻接矩阵
     */
    class Solution1 {
        public void dfs(int[][] M, boolean[] visited, int i) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] != 1 || visited[j]) {
                    continue;
                }
                visited[j] = true;
                dfs(M, visited, j);
            }
        }

        /**
         * N * N 的矩阵 M
         * <p>
         * N 名学生
         *
         * @param M
         * @return
         */
        public int findCircleNum(int[][] M) {
            boolean[] visited = new boolean[M.length];
            //连通块的个数
            int count = 0;
            for (int i = 0; i < M.length; i++) {
                if (visited[i]) {
                    continue;
                }
                //i是起点
                //还是tree好.tree的起点是root.
                dfs(M, visited, i);
                count++;
            }
            return count;
        }
    }

    /**
     * 方法 2：广度优先搜索
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/friend-circles/solution/peng-you-quan-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public int findCircleNum(int[][] M) {
            boolean[] visited = new boolean[M.length];
            int count = 0;
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < M.length; i++) {
                if (visited[i]) {
                    continue;
                }
                queue.add(i);
                while (!queue.isEmpty()) {
                    int s = queue.remove();
                    visited[s] = true;
                    for (int j = 0; j < M.length; j++) {
                        if (M[s][j] != 1 || visited[j]) {
                            continue;
                        }
                        queue.add(j);
                    }
                }
                count++;
            }
            return count;
        }
    }

}
