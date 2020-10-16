package com.leetcode.tag.dfs.two;

import java.util.stream.IntStream;

/**
 * 514. 自由之路
 * <p>
 * 有序-----双指针
 * <p>
 * 连通-----并查集
 * <p>
 * 递增递归.
 */
public class FindRotateSteps {
    class Solution {
        public int findRotateSteps(String ring, String key) {
            return dfs(ring, key, 0);
        }

        private int dfs(String ring, String key, int start) {
            if (start >= key.length()) {
                return 0;
            }
            int index = IntStream.range(0, ring.length())
                    .filter(i -> ring.charAt(i) == key.charAt(start)).findFirst().orElse(0);

            int result = index + 1;
            if (ring.charAt(0) == key.charAt(start)) {
                result += dfs(ring, key, start + 1);
            } else {
                if (index + 1 < ring.length()) {
                    result += dfs(ring.substring(index + 1) + ring.substring(0, index + 1), key, start + 1);
                }
            }

            return result;
        }
    }
}
