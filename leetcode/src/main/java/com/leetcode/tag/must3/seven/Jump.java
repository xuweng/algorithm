package com.leetcode.tag.must3.seven;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 45. 跳跃游戏 II
 */
public class Jump {
    class Solution {
        public int jump(int[] nums) {
            int n = nums.length;
            int ans = 0;
            boolean[] st = new boolean[n];
            Deque<Integer> d = new ArrayDeque<>();
            st[0] = true;
            d.addLast(0);
            while (!d.isEmpty()) {
                int size = d.size();
                while (size-- > 0) {
                    int idx = d.pollFirst();
                    if (idx == n - 1) {
                        return ans;
                    }
                    for (int i = idx + 1; i <= idx + nums[idx] && i < n; i++) {
                        if (!st[i]) {
                            st[i] = true;
                            d.addLast(i);
                        }
                    }
                }
                ans++;
            }
            return ans;
        }
    }

    class Solution1 {
        public int jump(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int[] dp = new int[nums.length];
            Arrays.fill(dp, Integer.MAX_VALUE - 1);
            dp[0] = 0;

            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] >= i - j) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }

            return dp[nums.length - 1];
        }
    }
}
