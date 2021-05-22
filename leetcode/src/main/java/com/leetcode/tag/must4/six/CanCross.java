package com.leetcode.tag.must4.six;

import java.util.HashMap;
import java.util.Map;

/**
 * 403. 青蛙过河
 * <p>
 * 一一分配 一一分配 一一分配
 * <p>
 * 一一分配 一一分配 一一分配
 * <p>
 * i j 模型
 * <p>
 * i j 模型
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

            // 0到1 1步
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
}
