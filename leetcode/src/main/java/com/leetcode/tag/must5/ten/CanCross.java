package com.leetcode.tag.must5.ten;

import java.util.HashMap;
import java.util.Map;

/**
 * 403. 青蛙过河
 */
public class CanCross {
    class Solution {
        Map<Integer, Integer> map = new HashMap<>();
        Map<String, Boolean> meno = new HashMap<>();

        public boolean canCross(int[] stones) {
            if (stones[1] != 1) {
                return false;
            }
            if (stones.length == 2) {
                return true;
            }
            for (int i = 0; i < stones.length; i++) {
                map.put(stones[i], i);
            }

            // 0到1 1步
            return dfs(stones, 1, 1);
        }

        private boolean dfs(int[] stones, int index, int k) {
            String key = index + "_" + k;
            if (meno.containsKey(key)) {
                return meno.get(key);
            }
            if (index == stones.length - 1) {
                meno.put(key, true);
                return true;
            }
            for (int i = k - 1; i <= k + 1; i++) {
                if (i == 0) {
                    continue;
                }
                int next = stones[index] + i;
                if (!map.containsKey(next)) {
                    continue;
                }
                Integer nextIndex = map.get(next);
                boolean is = dfs(stones, nextIndex, i);
                if (is) {
                    meno.put(key, true);
                    return true;
                }
            }
            meno.put(key, false);
            return false;
        }
    }

    class Solution1 {
        public boolean canCross(int[] stones) {
            if (stones[1] != 1) {
                return false;
            }
            if (stones.length == 2) {
                return true;
            }

            boolean[][] dp = new boolean[stones.length][stones.length];
            dp[1][1] = true;

            for (int i = 2; i < stones.length; i++) {
                for (int j = 1; j < i; j++) {
                    int k = stones[i] - stones[j];
                    if (k > j + 1) {
                        continue;
                    }
                    dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];
                }
            }
            for (int i = 0; i < stones.length; i++) {
                if (dp[stones.length - 1][i]) {
                    return true;
                }
            }

            return false;
        }
    }
}
