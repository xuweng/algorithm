package com.leetcode.tag.must5.six;

import java.util.Arrays;

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

    /**
     * 前缀和 + dp
     */
    class Solution3 {
        public boolean canReach(String s, int minJump, int maxJump) {
            int len = s.length();
            char[] chars = s.toCharArray();
            //记录某个点是否能达到 如果能到就是0 ,不能达到就是1
            int[] dp = new int[len + 1];
            //首先设置所有的点都不能达到
            Arrays.fill(dp, 1);
            //但是chars[0] = '0' 那么第一个点一定是能达到的 那么设置为 0
            dp[1] = 0;
            //这个是前缀和的数组，记录的是dp这个数组的前缀和
            int[] pre = new int[len + 1];
            //第一个一定是0
            pre[1] = 0;
            //遍历数组
            for (int i = 2; i <= len; i++) {
                // 选择chars[i - 1]为 0  通过判断这个点的 i - maxJump 到 i - minJump 点的和 是否比 这两个点的距离之和近
                // 如果近就说明这里面至少存在一个0 那么就可以通过这个0 来到达chars[i - 1]这个点
                if (chars[i - 1] == '0') {
                    if (i - minJump >= 1) {
                        // [l,r]
                        // 区间长度 r-l+1
                        // 区间和 pre[r]-pre[l-1]
                        int r = i - minJump;
                        int l = Math.max(i - maxJump, 1);
                        dp[i] = pre[r] - pre[l - 1] < r - l + 1 ? 0 : 1;
                    }
                }
                //每次都维护前缀和数组,加入 0 或者 1
                pre[i] += pre[i - 1] + dp[i];
            }

            return dp[len] == 0;
        }
    }
}
