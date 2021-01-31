package com.leetcode.tag.daily.seven;

/**
 * 839. 相似字符串组
 * <p>
 * 字符串分组 连通个数
 */
public class NumSimilarGroups {
    /**
     * 方法一：并查集
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/similar-string-groups/solution/xiang-si-zi-fu-chuan-zu-by-leetcode-solu-8jt9/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        int[] f;

        public int numSimilarGroups(String[] strs) {
            int n = strs.length;
            int m = strs[0].length();
            f = new int[n];
            // 初始化parent
            for (int i = 0; i < n; i++) {
                f[i] = i;
            }

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int fi = find(i), fj = find(j);
                    if (fi == fj) {
                        continue;
                    }
                    if (check(strs[i], strs[j], m)) {
                        // 连接相似字符串
                        f[fi] = fj;
                    }
                }
            }
            // 连通分量数量
            int ret = 0;
            for (int i = 0; i < n; i++) {
                if (f[i] == i) {
                    ret++;
                }
            }
            return ret;
        }

        public int find(int x) {
            return f[x] == x ? x : (f[x] = find(f[x]));
        }

        /**
         * 是否只有2个字符不同
         *
         * @param a
         * @param b
         * @param len
         * @return
         */
        public boolean check(String a, String b, int len) {
            int num = 0;
            for (int i = 0; i < len; i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    num++;
                    if (num > 2) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    class Solution1 {
        public int numSimilarGroups(String[] strs) {
            int n = strs.length;
            int m = strs[0].length();

            UF uf = new UF(n);

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (check(strs[i], strs[j], m)) {
                        // 连接相似字符串
                        uf.union(i, j);
                    }
                }
            }
            // 连通分量数量
            return uf.count;
        }

        class UF {
            private int[] parent;
            private int count;

            UF(int n) {
                parent = new int[n];
                count = n;

                for (int i = 0; i < parent.length; i++) {
                    parent[i] = i;
                }
            }

            private int find(int i) {
                if (parent[i] != i) {
                    parent[i] = find(parent[i]);
                }

                return parent[i];
            }

            private boolean isConnect(int i, int j) {
                return find(i) == find(j);
            }

            private boolean union(int i, int j) {
                int rootI = find(i);
                int rootJ = find(j);

                if (rootI == rootJ) {
                    return false;
                }
                parent[rootI] = rootJ;
                count--;

                return true;
            }
        }

        /**
         * 是否只有2个字符不同
         *
         * @param a
         * @param b
         * @param len
         * @return
         */
        public boolean check(String a, String b, int len) {
            int num = 0;
            for (int i = 0; i < len; i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    num++;
                    if (num > 2) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
