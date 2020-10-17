package com.leetcode.tag.dfs.two;

import java.util.ArrayList;
import java.util.List;
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
    /**
     * 用多种不同的测试用例测试.有些测试用例不通过.
     * <p>
     * 重复字符不通过.重复数据始终是坑.
     * <p>
     * 还是有些测试用例不通过
     * <p>
     * 数字字符串.
     */
    class Solution {
        /**
         * 测试用例
         * <p>
         * "inggodd"
         * "o"
         *
         * @param ring
         * @param key
         * @return
         */
        public int findRotateSteps(String ring, String key) {
            return dfs(ring, key, 0);
        }

        private int dfs(String ring, String key, int start) {
            if (start >= key.length()) {
                return 0;
            }
            if (ring.charAt(0) == key.charAt(start)) {
                return 1 + dfs(ring, key, start + 1);
            }
            int index = IntStream.range(0, ring.length())
                    .filter(i -> ring.charAt(i) == key.charAt(start)).findFirst().orElse(0);

            int result = index + 1;
            if (index < ring.length()) {
                result += dfs(ring.substring(index) + ring.substring(0, index), key, start + 1);
            }

            return result;
        }
    }

    /**
     * dfs
     * <p>
     * 作者：acw_weian
     * 链接：https://leetcode-cn.com/problems/freedom-trail/solution/514-zi-you-zhi-lu-bao-li-dao-ji-yi-hua-sou-suo-by-/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        String ring, key;
        List<List<Integer>> pos;

        public int findRotateSteps(String ring, String key) {
            this.ring = ring;
            this.key = key;
            pos = new ArrayList<>(26);
            //记录ring上所有字符出现的位置。
            for (int i = 0; i < ring.length(); i++) {
                int pos = ring.charAt(i) - 'a';
                if (this.pos.get(pos) == null) {
                    this.pos.set(pos, new ArrayList<>());
                }
                this.pos.get(pos).add(i);
            }
            return dfs(0, 0);
        }

        /**
         * @param p1 在ring上的位置
         * @param p2 在key上的位置
         * @return
         */
        public int dfs(int p1, int p2) {
            if (p2 == key.length()) {
                return 0;
            }
            int res = Integer.MAX_VALUE;
            int p = key.charAt(p2) - 'a';
            for (Integer next : this.pos.get(p)) {
                int dist = Math.abs(p1 - next);
                dist = Math.min(dist, ring.length() - dist);
                res = Math.min(res, dist + dfs(next, p2 + 1) + 1);
            }
            return res;
        }

    }
}
