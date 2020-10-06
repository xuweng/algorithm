package com.leetcode.tag.dfs.one;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * 839. 相似字符串组
 * <p>
 * 无向图
 * <p>
 * 全局下标
 * <p>
 * 十分钟看答案.特别是hard题目.
 */
public class NumSimilarGroups {
    /**
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/similar-string-groups/solution/xiang-si-zi-fu-chuan-zu-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int numSimilarGroups(String[] A) {
            int N = A.length;
            int W = A[0].length();
            DSU dsu = new DSU(N);

            if (N < W * W) { // If few words, then check for pairwise similarity: O(N^2 W)
                for (int i = 0; i < N; ++i) {
                    for (int j = i + 1; j < N; ++j) {
                        if (similar(A[i], A[j])) {
                            dsu.union(i, j);
                        }
                    }
                }

            } else { // If short words, check all neighbors: O(N W^3)
                Map<String, List<Integer>> buckets = new HashMap<>();
                for (int i = 0; i < N; ++i) {
                    char[] L = A[i].toCharArray();
                    for (int j0 = 0; j0 < L.length; ++j0) {
                        for (int j1 = j0 + 1; j1 < L.length; ++j1) {
                            swap(L, j0, j1);
                            StringBuilder sb = new StringBuilder();
                            for (char c : L) {
                                sb.append(c);
                            }
                            buckets.computeIfAbsent(sb.toString(),
                                    x -> new ArrayList<>()).add(i);
                            swap(L, j0, j1);
                        }
                    }
                }

                for (int i1 = 0; i1 < A.length; ++i1) {
                    if (buckets.containsKey(A[i1])) {
                        for (int i2 : buckets.get(A[i1])) {
                            dsu.union(i1, i2);
                        }
                    }
                }
            }

            int ans = 0;
            for (int i = 0; i < N; ++i) {
                if (dsu.parent[i] == i) {
                    ans++;
                }
            }

            return ans;
        }

        /**
         * 使用一个辅助函数 similar(word1, word2) 为 true 当且仅当两个单词相似
         * <p>
         * 两个单词只有两个字符不一样
         *
         * @param word1
         * @param word2
         * @return
         */
        public boolean similar(String word1, String word2) {
            int diff = (int) IntStream.range(0, word1.length()).filter(i -> word1.charAt(i) != word2.charAt(i)).count();
            return diff <= 2;
        }

        public void swap(char[] A, int i, int j) {
            char tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
        }
    }

    class DSU {
        int[] parent;

        public DSU(int N) {
            parent = new int[N];
            for (int i = 0; i < N; ++i) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] == x) {
                return parent[x];
            }
            parent[x] = find(parent[x]);
            return parent[x];
        }

        public void union(int x, int y) {
            parent[find(x)] = find(y);
        }
    }

}
