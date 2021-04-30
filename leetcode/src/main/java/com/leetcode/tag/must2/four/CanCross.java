package com.leetcode.tag.must2.four;

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

            // 0---->1需要1步
            return dfs(stones, 1, 1);
        }

        private boolean dfs(int[] stones, int i, int k) {
            String key = i + "_" + k;
            if (i == stones.length - 1) {
                meno.put(key, true);
                return true;
            }
            for (int step = k - 1; step <= k + 1; step++) {
                if (step == 0) {
                    continue;
                }
                int next = stones[i] + step;
                if (!map.containsKey(next)) {
                    continue;
                }
                int nextIndex = map.get(next);
                boolean is = dfs(stones, nextIndex, step);
                if (is) {
                    meno.put(key, true);
                    return true;
                }
            }
            meno.put(key, false);
            return false;
        }
    }
}
