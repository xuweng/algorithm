package com.leetcode.tag.daily;

/**
 * 546. 移除盒子
 * <p>
 * 看懂了题目。看懂了题目。看懂了题目。看懂了题目。
 */
public class RemoveBoxes {
    /**
     * 连续 k 个盒子
     * <p>
     * 最大积分和
     * <p>
     * dp.
     */
    class Solution {
        public int removeBoxes(int[] boxes) {
            return 0;
        }
    }

    /**
     * 区间dp。区间dp。前面的选择影响后面的选择。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/remove-boxes/solution/yi-chu-he-zi-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int removeBoxes(int[] boxes) {
            int[][][] dp = new int[100][100][100];
            return calculatePoints(boxes, dp, 0, boxes.length - 1, 0);
        }

        public int calculatePoints(int[] boxes, int[][][] dp, int l, int r, int k) {
            if (l > r) {
                return 0;
            }
            if (dp[l][r][k] != 0) {
                return dp[l][r][k];
            }
            while (r > l && boxes[r] == boxes[r - 1]) {
                r--;
                k++;
            }
            dp[l][r][k] = calculatePoints(boxes, dp, l, r - 1, 0) + (k + 1) * (k + 1);
            for (int i = l; i < r; i++) {
                if (boxes[i] == boxes[r]) {
                    dp[l][r][k] = Math.max(dp[l][r][k], calculatePoints(boxes, dp, l, i, k + 1) + calculatePoints(boxes, dp, i + 1, r - 1, 0));
                }
            }
            return dp[l][r][k];
        }
    }

}
