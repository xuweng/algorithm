package com.leetcode.tag.dfs.three;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 851. 喧闹和富有
 * <p>
 * 有向图
 * <p>
 * 无向图
 * <p>
 * 环
 * <p>
 * 缓存.
 * <p>
 * 有向图.无向图.环.缓存.初始化.
 */
public class LoudAndRich {
    /**
     * 方法：缓存深度优先搜索法
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/loud-and-rich/solution/xuan-nao-he-fu-you-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        ArrayList<Integer>[] graph;
        int[] answer;
        int[] quiet;

        public int[] loudAndRich(int[][] richer, int[] quiet) {
            int N = quiet.length;
            graph = new ArrayList[N];
            answer = new int[N];
            this.quiet = quiet;

            for (int node = 0; node < N; ++node) {
                graph[node] = new ArrayList<>();
            }

            for (int[] edge : richer) {
                graph[edge[1]].add(edge[0]);
            }

            Arrays.fill(answer, -1);

            for (int node = 0; node < N; ++node) {
                dfs(node);
            }
            return answer;
        }

        public int dfs(int node) {
            if (answer[node] != -1) {
                // 缓存
                return answer[node];
            }
            // 初始化.厉害.
            answer[node] = node;
            for (int child : graph[node]) {
                int cand = dfs(child);
                if (quiet[cand] < quiet[answer[node]]) {
                    // 计算答案
                    answer[node] = cand;
                }
            }
            return answer[node];
        }
    }

}
