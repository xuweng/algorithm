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
        //x和y一一对应。一一对应。两者肯定有一个为0.
        //下右左上
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, 1, -1, 0};

        /**
         * 起点。起点。
         * <p>
         * 起点开始搜索。起点开始搜索。
         * <p>
         * 时间复杂度：O(n×m)
         * <p>
         * 空间复杂度：O(n×m)
         * <p>
         * 每个结点。
         * <p>
         * 穷举每个结点。和穷举二维数组有什么区别？
         * <p>
         * 题目要求：记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点
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
                //遍历上下左右4个方向。这是邻接结点。
                for (int i = 0; i < 4; i++) {
                    //新坐标。
                    int mx = x + dx[i], my = y + dy[i];
                    //入队条件。边界判断+没有搜索过。理解比较容易。
                    if (mx >= 0 && mx < n && my >= 0 && my < m && image[mx][my] == currColor) {
                        queue.offer(new int[]{mx, my});
                        //上色.
                        //入队后上色
                        image[mx][my] = newColor;
                    }
                }
            }
            return image;
        }
    }

    /**
     * 方法二：深度优先搜索
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/flood-fill/solution/tu-xiang-xuan-ran-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        //记住这个方法
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, 1, -1, 0};

        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            int currColor = image[sr][sc];
            if (currColor != newColor) {
                //已知起点。不用遍历。
                dfs(image, sr, sc, currColor, newColor);
            }
            return image;
        }

        public void dfs(int[][] image, int x, int y, int color, int newColor) {
            if (image[x][y] != color) {
                return;
            }
            //上色
            //上色后递归
            image[x][y] = newColor;
            //4个方向。4个方向。4个方向。
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i], my = y + dy[i];
                //边界.边界。边界
                if (mx >= 0 && mx < image.length && my >= 0 && my < image[0].length) {
                    dfs(image, mx, my, color, newColor);
                }
            }
        }
    }

}
