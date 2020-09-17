package com.leetcode.tag.daily.three;

/**
 * 684. 冗余连接
 * <p>
 * 并查集.3个函数:初始化、查找、合并.
 * <p>
 * 数组的下标表示结点
 * <p>
 * 比如vector[2] = 2，意味着2这个节点所在集合的代表节点就是2
 * <p>
 * 数组的下标表示结点,值存放parent,不是存放root
 * <p>
 * 根据高度来合并(UnionUnion byby RankRank)
 * 路径压缩(PathPath CompressionCompression)
 * <p>
 * https://leetcode-cn.com/problems/redundant-connection/solution/tong-su-jiang-jie-bing-cha-ji-bang-zhu-xiao-bai-ku/
 */
public class FindRedundantConnection {
    class Solution {
        //parents数组厉害.在数组上跳跃查询.
        int[] parents;

        public int[] findRedundantConnection(int[][] edges) {
            if (edges == null || edges.length == 0) {
                return new int[]{0, 0};
            }
            //注意此处下标多放一个
            int n = edges.length + 1;

            init(n);

            for (int[] edge : edges) {
                int x = edge[0], y = edge[1];
                if ((!union(x, y))) {
                    //root相同
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
         * 第一次路径压缩之后,高度降低,高度保持为1,后面的查询很快
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

            //在同一个集合
            if (rootX == rootY) {
                return false;
            }
            //rootX合并到rootY
            parents[rootX] = rootY;

            return true;
        }

    }
}
