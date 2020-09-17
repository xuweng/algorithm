package com.leetcode.tag.daily.three;

/**
 * 684. 冗余连接
 * <p>
 * 并查集
 * <p>
 * 根据高度来合并(UnionUnion byby RankRank)
 * 路径压缩(PathPath CompressionCompression)
 */
public class FindRedundantConnection {
    class Solution {
        int[] parents;

        public int[] findRedundantConnection(int[][] edges) {
            if (edges == null || edges.length == 0) {
                return new int[]{0, 0};
            }
            int n = edges.length + 1; //注意此处下标多放一个

            init(n);

            for (int[] edge : edges) {
                int x = edge[0], y = edge[1];
                if ((!union(x, y))) {
                    //第二次出现了联通的边时，表示已经找到了
                    return edge;
                }
            }
            return new int[]{0, 0};
        }

        /**
         * 初始化parents
         *
         * @param n
         */
        public void init(int n) {
            parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }

        /**
         * 递归版路径压缩，找到x的根节点
         * <p>
         * x的root且路径压缩
         *
         * @param x
         * @return x的root且路径压缩
         */
        public int find(int x) {
            if (x != parents[x]) {
                //路径上的每个结点都指向x的root
                parents[x] = find(parents[x]);
            }
            return parents[x];
        }

        /**
         * 第二次x和y的跟节点发现一致时，他们已经联通了，返回false
         * 改写union方法，第一次当x与y没有联通时，将其设置联通关系，返回ture
         *
         * @param x
         * @param y
         * @return
         */
        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return false;
            }
            parents[rootX] = rootY;
            return true;
        }

    }
}
