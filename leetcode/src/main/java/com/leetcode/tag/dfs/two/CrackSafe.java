package com.leetcode.tag.dfs.two;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 753. 破解保险箱
 * <p>
 * 十分钟.十分钟.十分钟.十分钟.十分钟.
 */
public class CrackSafe {
    /**
     * 方法一：Hierholzer 算法
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/cracking-the-safe/solution/po-jie-bao-xian-xiang-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        Set<Integer> seen = new HashSet<>();
        StringBuffer ans = new StringBuffer();
        int highest;
        int k;

        public String crackSafe(int n, int k) {
            highest = (int) Math.pow(10, n - 1);
            this.k = k;
            dfs(0);

            return ans.append(IntStream.range(1, n).mapToObj(i -> "0").collect(Collectors.joining())).toString();
        }

        public void dfs(int node) {
            for (int x = 0; x < k; ++x) {
                int nei = node * 10 + x;
                if (!seen.contains(nei)) {
                    seen.add(nei);
                    dfs(nei % highest);
                    ans.append(x);
                }
            }
        }
    }

}
