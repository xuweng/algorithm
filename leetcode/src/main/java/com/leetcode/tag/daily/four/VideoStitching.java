package com.leetcode.tag.daily.four;

import java.util.Arrays;

/**
 * 1024. 视频拼接
 * <p>
 * 搞懂题意.搞懂题目.搞懂题目.搞懂题目.
 */
public class VideoStitching {
    /**
     * 方法一：动态规划
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/video-stitching/solution/shi-pin-pin-jie-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        /**
         * 令 dp[i] 表示将区间 [0,i) 覆盖所需的最少子区间的数量
         *
         * @param clips
         * @param T
         * @return
         */
        public int videoStitching(int[][] clips, int T) {
            int[] dp = new int[T + 1];
            // 由于我们希望子区间的数目尽可能少，因此可以将所有 dp[i] 的初始值设为一个大整数
            Arrays.fill(dp, Integer.MAX_VALUE - 1);
            dp[0] = 0;
            for (int i = 1; i <= T; i++) {
                for (int[] clip : clips) {
                    if (clip[0] < i && i <= clip[1]) {
                        dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
                    }
                }
            }
            return dp[T] == Integer.MAX_VALUE - 1 ? -1 : dp[T];
        }
    }

}
