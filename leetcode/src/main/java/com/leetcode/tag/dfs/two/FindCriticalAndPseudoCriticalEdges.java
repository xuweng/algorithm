package com.leetcode.tag.dfs.two;

import java.util.*;

/**
 * 1489. 找到最小生成树里的关键边和伪关键边
 * <p>
 * 十分钟.十分钟.十分钟
 * <p>
 * 经典题目.经典题目.经典题目.经典题目.
 */
public class FindCriticalAndPseudoCriticalEdges {
    /**
     * 最小生成树Kruskal算法， 并查集
     * <p>
     * 作者：ClawnJ
     * 链接：https://leetcode-cn.com/problems/find-critical-and-pseudo-critical-edges-in-minimum-spanning-tree/solution/javabao-li-shuang-bai-zui-xiao-sheng-cheng-shu-kru/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
            HashMap<String, Integer> edgeIndex = new HashMap<>();
            for (int i = 0; i < edges.length; i++) {
                int from = edges[i][0];
                int to = edges[i][1];
                String edgeKey = concat(from, to);
                edgeIndex.put(edgeKey, i);
            }
            Arrays.sort(edges, Comparator.comparingInt(o -> o[2]));
            List<Integer> key = new ArrayList<>();
            List<Integer> fkey = new ArrayList<>();
            int[] root = new int[n];
            int[] rootCp = new int[n];

            for (int i = 0; i < n; i++) {
                root[i] = i;
            }

            int l, r = 0;
            while (r < edges.length) {
                l = r;
                while (r < edges.length && edges[r][2] == edges[l][2]) {
                    r++;
                }

                boolean[] abort = new boolean[r - l];
                boolean[] trueKey = new boolean[r - l];

                for (int j = l; j < r; j++) {
                    int from = edges[j][0], to = edges[j][1];
                    if (sameRoot(root, from, to)) {
                        abort[j - l] = true;
                    }
                }

                for (int i = l; i < r; i++) {
                    if (abort[i - l]) {
                        continue;
                    }
                    System.arraycopy(root, 0, rootCp, 0, n);
                    for (int j = l; j < r; j++) {
                        if (abort[j - l]) {
                            continue;
                        }
                        if (j == i) {
                            continue;
                        }
                        int from = edges[j][0], to = edges[j][1];
                        union(rootCp, from, to);
                    }
                    if (!sameRoot(rootCp, edges[i][0], edges[i][1])) {
                        trueKey[i - l] = true;
                        union(rootCp, edges[i][0], edges[i][1]);
                    }
                }

                for (int j = l; j < r; j++) {
                    if (abort[j - l]) {
                        continue;
                    }

                    int from = edges[j][0], to = edges[j][1];
                    String edgeKey = concat(from, to);

                    if (!trueKey[j - l]) {
                        fkey.add(edgeIndex.get(edgeKey));
                    } else {
                        key.add(edgeIndex.get(edgeKey));
                    }
                }
                System.arraycopy(rootCp, 0, root, 0, n);

                if (oneRoot(root)) {
                    break;
                }
            }
            List<List<Integer>> res = new ArrayList<>();
            res.add(key);
            res.add(fkey);
            return res;
        }

        String concat(int from, int to) {
            return from +
                    "," +
                    to;
        }

        void union(int[] root, int a, int b) {
            root[getRoot(root, a)] = getRoot(root, b);
        }

        int getRoot(int[] root, int n) {
            int p = n;
            while (root[p] != p) {
                p = root[p];
            }
            while (n != p) {
                int tmp = root[n];
                root[n] = p;
                n = tmp;
            }
            return p;
        }

        boolean oneRoot(int[] root) {
            int p = getRoot(root, 0);
            for (int i = 0; i < root.length; i++) {
                if (getRoot(root, i) != p) {
                    return false;
                }
            }
            return true;
        }

        boolean sameRoot(int[] root, int a, int b) {
            return getRoot(root, a) == getRoot(root, b);
        }
    }

}
