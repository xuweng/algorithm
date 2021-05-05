package com.leetcode.tag.must2.ten;

import java.util.HashMap;
import java.util.Map;

/**
 * 403. 青蛙过河
 */
public class CanCross {
    class Solution {
        Map<Integer, Integer> map = new HashMap<>();
        Map<String, Boolean> memo = new HashMap<>();

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

            // 0--->1 1步
            return dfs(stones, 1, 1);
        }

        private boolean dfs(int[] stones, int index, int step) {
            String key = index + "_" + step;
            if (memo.containsKey(key)) {
                return memo.get(key);
            }
            if (index == stones.length - 1) {
                memo.put(key, true);
                return true;
            }
            for (int i = step - 1; i <= step + 1; i++) {
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
                    memo.put(key, true);
                    return true;
                }
            }
            memo.put(key, false);
            return false;
        }
    }
}
