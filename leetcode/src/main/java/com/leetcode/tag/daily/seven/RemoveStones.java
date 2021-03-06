package com.leetcode.tag.daily.seven;

import java.util.HashMap;
import java.util.Map;

/**
 * 947. 移除最多的同行或同列石头
 * <p>
 * 题目说的是返回“可以移除的石子的最大数量”
 * <p>
 * 并查集
 */
public class RemoveStones {
    /**
     * 方法：并查集
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/most-stones-removed-with-same-row-or-column/solution/947-yi-chu-zui-duo-de-tong-xing-huo-tong-ezha/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public class Solution {
        public int removeStones(int[][] stones) {
            UnionFind unionFind = new UnionFind();

            for (int[] stone : stones) {
                // 二维转一维
                // 下面这三种写法任选其一
                // unionFind.union(~stone[0], stone[1]);
                // unionFind.union(stone[0] - 10001, stone[1]);
                unionFind.union(stone[0] + 10001, stone[1]);
            }
            return stones.length - unionFind.getCount();
        }

        class UnionFind {
            private Map<Integer, Integer> parent;
            private int count;

            public UnionFind() {
                this.parent = new HashMap<>();
                this.count = 0;
            }

            public int getCount() {
                return count;
            }

            public int find(int x) {
                if (!parent.containsKey(x)) {
                    parent.put(x, x);
                    // 并查集集中新加入一个结点，结点的父亲结点是它自己，所以连通分量的总数 +1
                    count++;
                }

                if (x != parent.get(x)) {
                    parent.put(x, find(parent.get(x)));
                }
                return parent.get(x);
            }

            public void union(int x, int y) {
                int rootX = find(x);
                int rootY = find(y);
                if (rootX == rootY) {
                    return;
                }

                parent.put(rootX, rootY);
                // 两个连通分量合并成为一个，连通分量的总数 -1
                count--;
            }
        }
    }

    /**
     * 方法1.按点合并
     */
    class Solution1 {
        int[] p = new int[1000];
        int count;

        int find(int x) {
            if (x != p[x]) {
                p[x] = find(p[x]);
            }
            return p[x];
        }

        /**
         * 简洁代码
         *
         * @param x
         * @param y
         */
        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return;
            }
            p[rootX] = rootY;
            count--;
        }

        public int removeStones(int[][] stones) {
            // 初始化
            int n = stones.length;
            count = n;
            for (int i = 0; i < n; i++) {
                p[i] = i;
            }

            // 遍历所有石头
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    // 同一列或者同一行 合并
                    if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                        union(i, j);
                    }
                }
            }

            return n - count;
        }
    }

}
