package com.leetcode.tag.must2.three;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 403. 青蛙过河
 */
public class CanCross {
    class Solution {
        public boolean canCross(int[] stones) {
            if (stones[1] != 1) {
                return false;
            }
            if (stones.length == 2) {
                return true;
            }
            Map<Integer, Integer> stonesMap = new HashMap<>();
            for (int i = 0; i < stones.length; i++) {
                stonesMap.put(stones[i], i);
            }
            // Set去重
            Map<Integer, Set<Integer>> map = new HashMap<>();
            map.computeIfAbsent(1, v -> new HashSet<>()).add(1);
            for (int i = 1; i < stones.length; i++) {
                if (!map.containsKey(i)) {
                    continue;
                }
                Set<Integer> set = map.get(i);
                for (Integer j : set) {
                    for (int step = j - 1; step <= j + 1; step++) {
                        if (step == 0) {
                            continue;
                        }
                        int next = stones[i] + step;
                        if (stonesMap.containsKey(next)) {
                            Integer index = stonesMap.get(next);
                            if (index == stones.length - 1) {
                                return true;
                            }
                            map.computeIfAbsent(index, v -> new HashSet<>()).add(step);
                        }
                    }
                }
            }

            return false;
        }
    }

    class Solution1 {
        Map<Integer, Integer> stonesMap = new HashMap<>();

        public boolean canCross(int[] stones) {
            if (stones[1] != 1) {
                return false;
            }
            if (stones.length == 2) {
                return true;
            }
            for (int i = 0; i < stones.length; i++) {
                stonesMap.put(stones[i], i);
            }

            // 0---》1需要1步
            return dfs(stones, 1, 1);
        }

        private boolean dfs(int[] stones, int index, int k) {
            if (index == stones.length - 1) {
                return true;
            }
            for (int i = k - 1; i <= k + 1; i++) {
                if (i == 0) {
                    continue;
                }
                int next = stones[index] + i;
                if (!stonesMap.containsKey(next)) {
                    continue;
                }
                Integer nextIndex = stonesMap.get(next);
                // index--->nextIndex i步
                if (dfs(stones, nextIndex, i)) {
                    return true;
                }
            }

            return false;
        }
    }

    class Solution2 {
        Map<Integer, Integer> stonesMap = new HashMap<>();
        Map<String, Boolean> meno = new HashMap<>();

        public boolean canCross(int[] stones) {
            if (stones[1] != 1) {
                return false;
            }
            if (stones.length == 2) {
                return true;
            }
            for (int i = 0; i < stones.length; i++) {
                stonesMap.put(stones[i], i);
            }

            // 0---》1需要1步
            return dfs(stones, 1, 1);
        }

        private boolean dfs(int[] stones, int index, int k) {
            String key = index + "_" + k;
            if (meno.containsKey(key)) {
                return meno.get(key);
            }
            if (index == stones.length - 1) {
                return true;
            }
            for (int i = k - 1; i <= k + 1; i++) {
                if (i == 0) {
                    continue;
                }
                int next = stones[index] + i;
                if (!stonesMap.containsKey(next)) {
                    continue;
                }
                Integer nextIndex = stonesMap.get(next);
                // index--->nextIndex i步
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

    class Solution3 {
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
