package com.leetcode.tag.must5.six;

/**
 * 1871. 跳跃游戏 VII
 * <p>
 * 优先队列 优先队列 优先队列
 * <p>
 * 二分 二分 二分 二分
 */
public class CanReach {
    /**
     * 方法一：动态规划 + 前缀和优化
     */
    class Solution {
        public boolean canReach(String s, int minJump, int maxJump) {
            char[] copy = s.toCharArray();
            if (copy[copy.length - 1] != '0') {
                return false;
            }
            boolean[] dp = new boolean[copy.length];
            dp[copy.length - 1] = true;

            // count记录窗口中true的数量
            int count = 0;
            for (int cur = copy.length - 2; cur >= 0; cur--) {
                int left = cur + minJump;
                int right = cur + maxJump + 1;
                if (left <= copy.length - 1) {
                    if (dp[left]) {
                        count++;
                    }
                }
                if (right <= copy.length - 1) {
                    if (dp[right]) {
                        count--;
                    }
                }
                dp[cur] = count > 0;
                if (copy[cur] != '0') {
                    dp[cur] = false;
                }
            }

            return dp[0];

        }
    }

    /**
     * 滑窗思想+dp
     */
    class Solution1 {
        public boolean canReach(String s, int minJump, int maxJump) {
            int n = s.length();
            boolean[] dp = new boolean[n];
            dp[0] = true;
            // 滑窗cnt初始化，一开始i = 0是可达的，所以cnt初始化为1
            int cnt = 1;
            for (int i = minJump; i < n; ++i) {
                // 判断当前坐标是否可达
                if (s.charAt(i) == '0' && cnt > 0) {
                    dp[i] = true;
                }
                // 滑窗移动后左端坐标离开带来的更新
                if (i >= maxJump && dp[i - maxJump]) {
                    --cnt;
                }
                // 滑窗移动后右端坐标加入带来的更新
                if (dp[i - minJump + 1]) {
                    ++cnt;
                }
            }
            return dp[n - 1];
        }
    }

    class Solution2 {
        public boolean canReach(String s, int minJump, int maxJump) {
            int n = s.length();
            boolean[] f = new boolean[n];
            int[] pre = new int[n];
            f[0] = true;
            // 由于我们从 i=minJump 开始动态规划，因此需要将 [0,minJump) 这部分的前缀和预处理出来
            for (int i = 0; i < minJump; ++i) {
                pre[i] = 1;
            }
            for (int i = minJump; i < n; ++i) {
                int left = i - maxJump, right = i - minJump;
                if (s.charAt(i) == '0') {
                    int total = pre[right] - (left <= 0 ? 0 : pre[left - 1]);
                    f[i] = (total != 0);
                }
                pre[i] = pre[i - 1] + (f[i] ? 1 : 0);
            }
            return f[n - 1];
        }
    }
}
