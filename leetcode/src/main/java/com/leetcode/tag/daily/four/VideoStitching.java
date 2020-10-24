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
            // 枚举所有的子区间来依次计算出所有的 dp 值
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

    /**
     * 方法二：贪心
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/video-stitching/solution/shi-pin-pin-jie-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int videoStitching(int[][] clips, int T) {
            // 对于每一个位置 i，我们记录以其为左端点的子区间中最远的右端点，记为 maxn[i]
            int[] maxn = new int[T];
            for (int[] clip : clips) {
                if (clip[0] < T) {
                    maxn[clip[0]] = Math.max(maxn[clip[0]], clip[1]);
                }
            }

            // 当枚举到位置 i 时，记左端点不大于 i 的所有子区间的最远右端点为 last
            // last 就代表了当前能覆盖到的最远的右端点
            int last = 0;
            int ret = 0;
            int pre = 0;
            for (int i = 0; i < T; i++) {
                last = Math.max(last, maxn[i]);
                if (i == last) {
                    return -1;
                }
                if (i == pre) {
                    ret++;
                    pre = last;
                }
            }
            return ret;
        }
    }

}
