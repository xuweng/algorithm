package com.leetcode.tag.daily.two;

import java.util.List;

/**
 * 841. 钥匙和房间
 * <p>
 * 太晦涩的题目直接看答案
 */
public class CanVisitAllRooms {
    class Solution {
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            return true;
        }
    }

    /**
     * 将这 n 个房间看成有向图中的 n 个节点，那么上述关系就可以看作是图中的 x 号点到 y 号点的一条有向边
     * <p>
     * 抽象图的结点和边
     * <p>
     * 方法一：深度优先搜索
     * <p>
     * 问题就变成了给定一张有向图，询问从 0 号节点出发是否能够到达所有的节点
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/keys-and-rooms/solution/yao-chi-he-fang-jian-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        boolean[] vis;
        int num;

        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            int n = rooms.size();
            num = 0;
            vis = new boolean[n];
            dfs(rooms, 0);
            return num == n;
        }

        public void dfs(List<List<Integer>> rooms, int x) {
            vis[x] = true;
            num++;
            for (int it : rooms.get(x)) {
                if (vis[it]) {
                    continue;
                }
                dfs(rooms, it);
                //不需要回溯
            }
        }

    }
}
