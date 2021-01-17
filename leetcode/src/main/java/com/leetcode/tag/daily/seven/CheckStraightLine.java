package com.leetcode.tag.daily.seven;

/**
 * 1232. 缀点成线
 */
public class CheckStraightLine {
    class Solution {
        public boolean checkStraightLine(int[][] coordinates) {
            if (coordinates == null || coordinates.length == 0) {
                return false;
            }

            int k = coordinates[0][1] - coordinates[0][0];
            for (int[] coordinate : coordinates) {
                if (coordinate[1] - coordinate[0] != k) {
                    return false;
                }
            }

            return true;
        }
    }

    /**
     * 方法一：数学
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/check-if-it-is-a-straight-line/solution/zhui-dian-cheng-xian-by-leetcode-solutio-lpt6/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public boolean checkStraightLine(int[][] coordinates) {
            int deltaX = coordinates[0][0], deltaY = coordinates[0][1];
            int n = coordinates.length;
            for (int i = 0; i < n; i++) {
                coordinates[i][0] -= deltaX;
                coordinates[i][1] -= deltaY;
            }
            int A = coordinates[1][1], B = -coordinates[1][0];
            for (int i = 2; i < n; i++) {
                int x = coordinates[i][0], y = coordinates[i][1];
                if (A * x + B * y != 0) {
                    return false;
                }
            }
            return true;
        }
    }

}
