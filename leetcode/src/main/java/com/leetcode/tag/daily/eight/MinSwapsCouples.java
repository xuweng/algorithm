package com.leetcode.tag.daily.eight;

import java.util.*;

/**
 * 765. 情侣牵手
 * <p>
 * 本质 本质 本质
 * <p>
 * 滑动窗口 哈希表
 */
public class MinSwapsCouples {
    /**
     * 方法一：并查集
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/couples-holding-hands/solution/qing-lu-qian-shou-by-leetcode-solution-bvzr/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int minSwapsCouples(int[] row) {
            int n = row.length;
            int tot = n / 2;
            int[] f = new int[tot];
            for (int i = 0; i < tot; i++) {
                f[i] = i;
            }

            for (int i = 0; i < n; i += 2) {
                int l = row[i] / 2;
                int r = row[i + 1] / 2;
                add(f, l, r);
            }

            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < tot; i++) {
                int fx = getf(f, i);
                // 统计每个连通分量的元素个数
                map.put(fx, map.getOrDefault(fx, 0) + 1);
            }

            return map.values().stream().mapToInt(integer -> integer - 1).sum();
        }

        public int getf(int[] f, int x) {
            if (f[x] == x) {
                return x;
            }
            int newf = getf(f, f[x]);
            f[x] = newf;
            return newf;
        }

        public void add(int[] f, int x, int y) {
            int fx = getf(f, x);
            int fy = getf(f, y);
            f[fx] = fy;
        }
    }

    /**
     * 方法二：广度优先搜索
     * <p>
     * 图bfs dfs 遍历每个顶点 对每个顶点bfs dfs
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/couples-holding-hands/solution/qing-lu-qian-shou-by-leetcode-solution-bvzr/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int minSwapsCouples(int[] row) {
            int n = row.length;
            int tot = n / 2;

            List<Integer>[] graph = new List[tot];
            for (int i = 0; i < tot; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int i = 0; i < n; i += 2) {
                int l = row[i] / 2;
                int r = row[i + 1] / 2;
                if (l != r) {
                    graph[l].add(r);
                    graph[r].add(l);
                }
            }
            boolean[] visited = new boolean[tot];
            int ret = 0;
            for (int i = 0; i < tot; i++) {
                if (visited[i]) {
                    continue;
                }
                // 从i开始bfs
                Queue<Integer> queue = new LinkedList<>();
                visited[i] = true;
                queue.offer(i);
                // 连通分量元素个数
                int cnt = 0;

                while (!queue.isEmpty()) {
                    int x = queue.poll();
                    cnt++;

                    for (int y : graph[x]) {
                        if (!visited[y]) {
                            // 邻接顶点入队
                            visited[y] = true;
                            queue.offer(y);
                        }
                    }
                }
                ret += cnt - 1;
            }
            return ret;
        }
    }

}
