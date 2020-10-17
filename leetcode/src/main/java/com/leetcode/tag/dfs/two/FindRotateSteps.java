package com.leetcode.tag.dfs.two;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    /**
     * 记忆化搜索
     * <p>
     * 作者：acw_weian
     * 链接：https://leetcode-cn.com/problems/freedom-trail/solution/514-zi-you-zhi-lu-bao-li-dao-ji-yi-hua-sou-suo-by-/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        String ring, key;
        List<Integer>[] pos;
        Map<Integer, Map<Integer, Integer>> memo = new HashMap<>();

        public int findRotateSteps(String ring, String key) {
            this.ring = ring;
            this.key = key;
            pos = new List[26];
            for (int i = 0; i < ring.length(); i++) {
                int p = ring.charAt(i) - 'a';
                if (pos[p] == null) {
                    pos[p] = new ArrayList<>();
                }
                pos[p].add(i);
            }
            return dfs(0, 0);
        }

        /**
         * 结果只与p1, p2相关， 把p1,p2当成key值，就可以加入记忆化搜索
         *
         * @param p1 在ring上的位置
         * @param p2 在key上的位置
         * @return
         */
        public int dfs(int p1, int p2) {
            if (p2 == key.length()) {
                return 0;
            }
            if (memo.containsKey(p1) && memo.get(p1).containsKey(p2)) {
                return memo.get(p1).get(p2);
            }
            int p = key.charAt(p2) - 'a';
            int res = Integer.MAX_VALUE;
            for (Integer next : pos[p]) {
                int dist = Math.abs(p1 - next);
                dist = Math.min(dist, ring.length() - dist);
                res = Math.min(res, dist + dfs(next, p2 + 1) + 1);
            }
            memo.computeIfAbsent(p1, k -> new HashMap<>()).put(p2, res);
            return res;
        }

    }

    /**
     * 动态规划
     * <p>
     * 作者：viktorxhzj
     * 链接：https://leetcode-cn.com/problems/freedom-trail/solution/javadong-tai-gui-hua-by-viktorxhzj/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution4 {
        public int findRotateSteps(String ring, String key) {
            /*
             * 贪心的算法：->举出了反例，是不正确的
             *
             * 最直观的转移方程：
             *
             * dp[i]: 代表到key[i]为止，拼接所需要的最少步数
             * dp[i-1]: 到key[i - 1]为止，拼接所需要的最少步数
             *
             * dp[i] = dp[i - 1] + (从key[i-1]到key[i]在圆盘上所要走的最短距离) + 1 （按button需要的步数为1）
             *
             * 下标x和下标y在圆盘上的最短距离： |x - y| 或者 n - |x - y|
             * 即Math.min(Math.abs(x - y), n - Math.abs(x - y))
             *
             * 但是，
             * key[i-1] 在圆盘上可以出现多次
             * key[i] 在圆盘上可以出现多次
             * 因此一个维度是不够的，再增加一个维度
             *
             * 定义转移方程：
             * dp[i][j] 代表到key[i]为止拼接所需要的最少步数，
             * 并且这个key[i]是第j个在圆盘上出现的key[i]
             *
             * 比如说key[i] = 'd'，在ring圆盘上出现位置的下标：2, 7, 8
             * dp[i][0] 代表到key[i]为止拼接所需要的最少步数，并且这个key[i]是位于下标位置为2的key[i]
             * dp[i][1] 代表到key[i]为止拼接所需要的最少步数，并且这个key[i]是位于下标位置为7的key[i]
             * ...以此类推
             *
             * 上一个字符是key[i-1] = 'a'，在ring圆盘上出现的位置下标是: 4, 9
             * dp[i][0] 代表到key[i - 1]为止拼接所需要的最少步数，并且这个key[i - 1]是位于下标位置为4的key[i]
             * dp[i][1] 代表到key[i - 1]为止拼接所需要的最少步数，并且这个key[i - 1]是位于下标位置为9的key[i]
             *
             * dp[i][j] =
             * Math.min(
             * dp[i-1][0] + 上一个字符key[i-1]（第0个出现的key[i - 1]）到这一个字符key[i]（第j个出现的key[i]）的最短距离,
             * dp[i-1][1] + 上一个字符key[i-1]（第1个出现的key[i - 1]）到这一个字符key[i]（第j个出现的key[i]）的最短距离,
             * ....
             * dp[i-1][k] + 上一个字符key[i-1]（第k个出现的key[i - 1]）到这一个字符key[i]（第j个出现的key[i]）的最短距离,
             * )  + 1 (按button的步数为1)
             * */

            char[] ringChar = ring.toCharArray();
            char[] keyChar = key.toCharArray();

            ArrayList<Integer>[] lists = new ArrayList[26];

            for (int i = 0; i < 26; i++) {
                lists[i] = new ArrayList<>();
            }

            // 遍历ring，存储每个字符出现的位置，即下标

            int n = ringChar.length, m = keyChar.length;

            for (int i = 0; i < n; i++) {
                char c = ringChar[i];
                // 找到对应的arraylist，存储下标
                lists[c - 'a'].add(i);
            }

            // ring 和 key的长度最多100，所以定个150很安全
            int[][] dp = new int[m][150];

            // dp[0][j] 只需要计算从12点方向到key[0]所需要走的最短距离

            for (int j = 0; j < lists[keyChar[0] - 'a'].size(); j++) {

                // 每一个key[0]字符所在的下标
                int x = lists[keyChar[0] - 'a'].get(j);

                // 第一个12点方向的字符的下标，其实就是0
                int y = lists[ringChar[0] - 'a'].get(0);

                dp[0][j] = Math.min(Math.abs(x - y), n - Math.abs(x - y)) + 1;
            }

            for (int i = 1; i < keyChar.length; i++) {

                // 列出当前的字符，和上一个的字符分别是什么
                char cur = keyChar[i], pre = keyChar[i - 1];

                for (int j = 0; j < lists[cur - 'a'].size(); j++) {
                    // 当前字符cur出现在ring圆盘上每一个位置的下标
                    int x = lists[cur - 'a'].get(j);

                    int minSteps = Integer.MAX_VALUE;

                    for (int k = 0; k < lists[pre - 'a'].size(); k++) {

                        // 上一个字符pre出现在ring圆盘上每一个位置的下标
                        int y = lists[pre - 'a'].get(k);

                        int steps = dp[i - 1][k] + Math.min(Math.abs(x - y), n - Math.abs(x - y)) + 1;

                        minSteps = Math.min(minSteps, steps);
                    }

                    dp[i][j] = minSteps;
                }
            }

            // dp[keyChar.length - 1][0], .... dp[keyChar.length - 1][k] 中的最小值，就是最终拼接key所需要的最少步数

            int ans = Integer.MAX_VALUE;
            for (int k = 0; k < 150; k++) {
                // 当等于0时，说明已经越界了，直接跳出循环
                if (dp[keyChar.length - 1][k] == 0) {
                    break;
                }
                ans = Math.min(ans, dp[keyChar.length - 1][k]);
            }

            return ans;

        }

    }

}
