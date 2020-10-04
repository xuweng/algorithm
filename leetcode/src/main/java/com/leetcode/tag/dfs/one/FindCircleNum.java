package com.leetcode.tag.dfs.one;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 547. 朋友圈.
 * <p>
 * 搞懂题意.
 * <p>
 * 无向图.搞懂题意.
 * <p>
 * 邻接矩阵.邻接表.每行都代表顶点.
 */
public class FindCircleNum {
    /**
     * 按照坐标dfs
     */
    class Solution {
        int[] r = {-1, 1, 0, 0};
        int[] c = {0, 0, -1, 1};
        boolean[][] used;

        /**
         * 按照坐标dfs
         *
         * @param M
         * @return
         */
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
     * 按照图的顶点dfs
     * <p>
     * 邻接矩阵的dfs
     * <p>
     * 图的遍历.可能有些顶点没有连通.需要从每个顶点开始dfs.
     * <p>
     * 方法 1：深度优先搜索
     * <p>
     * 把 M 看成图的邻接矩阵
     */
    class Solution1 {
        /**
         * @param M
         * @param visited
         * @param i       顶点.邻接矩阵.其实是每行.
         */
        public void dfs(int[][] M, boolean[] visited, int i) {
            //遍历第i行的列
            //遍历顶点i的邻接顶点
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] != 1 || visited[j]) {
                    continue;
                }
                visited[j] = true;
                dfs(M, visited, j);
                //visited没有回溯
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
            //顶点是否访问过.不是坐标.
            boolean[] visited = new boolean[M.length];
            //连通块的个数
            int count = 0;
            //遍历每行.遍历每个顶点.
            for (int i = 0; i < M.length; i++) {
                if (visited[i]) {
                    continue;
                }
                //i是顶点
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
            ////顶点是否访问过.不是坐标.
            boolean[] visited = new boolean[M.length];
            int count = 0;
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < M.length; i++) {
                if (visited[i]) {
                    continue;
                }
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int s = queue.poll();
                    visited[s] = true;
                    //顶点s的邻接顶点入队
                    for (int j = 0; j < M.length; j++) {
                        if (M[s][j] != 1 || visited[j]) {
                            continue;
                        }
                        queue.offer(j);
                    }
                }
                count++;
            }
            return count;
        }
    }

    /**
     * 方法 3：并查集
     * <p>
     * 复杂度分析
     * 时间复杂度：O(n^3)，访问整个矩阵一次，并查集操作需要最坏 O(n) 的时间。
     * 空间复杂度：O(n)，parent 大小为 n。
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/friend-circles/solution/peng-you-quan-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution3 {
        /**
         * 没有路径压缩
         *
         * @param parent
         * @param i
         * @return
         */
        int find(int[] parent, int i) {
            return parent[i] == -1 ? i : find(parent, parent[i]);
        }

        /**
         * x合并到y
         *
         * @param parent
         * @param x
         * @param y
         */
        void union(int[] parent, int x, int y) {
            int xRoot = find(parent, x);
            int yRoot = find(parent, y);

            if (xRoot != yRoot) {
                parent[xRoot] = yRoot;
            }
        }

        public int findCircleNum(int[][] M) {
            int[] parent = new int[M.length];
            Arrays.fill(parent, -1);

            for (int i = 0; i < M.length; i++) {
                for (int j = 0; j < M.length; j++) {
                    if (M[i][j] == 1 && i != j) {
                        //i合并到j
                        union(parent, i, j);
                    }
                }
            }
            //统计root的个数
            return (int) Arrays.stream(parent).filter(j -> j == -1).count();
        }
    }

}
