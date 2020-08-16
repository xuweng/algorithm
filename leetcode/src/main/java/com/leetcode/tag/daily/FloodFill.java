package com.leetcode.tag.daily;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 733. 图像渲染
 * <p>
 * 搞懂题目。穷举。
 * <p>
 * 搞懂题目。穷举。
 * <p>
 * 搞懂题目。穷举。
 * <p>
 * 搞懂题目。穷举。
 * <p>
 * 穷举就算了。其他算法。
 * <p>
 * 其他算法。其他算法。其他算法。
 * <p>
 * dfs。bfs。
 * <p>
 * dfs。dfs。
 */
public class FloodFill {
    class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            return null;
        }
    }

    /**
     * 方法一：广度优先搜索
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/flood-fill/solution/tu-xiang-xuan-ran-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, 1, -1, 0};

        /**
         * 起点。起点。
         * <p>
         * 起点开始搜索。起点开始搜索。
         *
         * @param image
         * @param sr
         * @param sc
         * @param newColor
         * @return
         */
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            int currColor = image[sr][sc];
            if (currColor == newColor) {
                return image;
            }
            int n = image.length, m = image[0].length;
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{sr, sc});
            image[sr][sc] = newColor;
            while (!queue.isEmpty()) {
                int[] cell = queue.poll();
                int x = cell[0], y = cell[1];
                for (int i = 0; i < 4; i++) {
                    int mx = x + dx[i], my = y + dy[i];
                    if (mx >= 0 && mx < n && my >= 0 && my < m && image[mx][my] == currColor) {
                        queue.offer(new int[]{mx, my});
                        image[mx][my] = newColor;
                    }
                }
            }
            return image;
        }
    }

}
