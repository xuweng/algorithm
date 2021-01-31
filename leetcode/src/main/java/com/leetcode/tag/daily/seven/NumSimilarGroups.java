package com.leetcode.tag.daily.seven;

/**
 * 839. 相似字符串组
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

}
