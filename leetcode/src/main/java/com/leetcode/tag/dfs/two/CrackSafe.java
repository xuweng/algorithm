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
     * 求解欧拉回路 / 欧拉通路的题目
     * <p>
     * 回路嵌套
     * <p>
     * []嵌套
     * <p>
     * Hierholzer 算法如下：
     * <p>
     * 我们从节点 u 开始，任意地经过还未经过的边，直到我们「无路可走」。此时我们一定回到了节点 u，这是因为所有节点的入度和出度都相等。
     * <p>
     * 回到节点 u 之后，我们得到了一条从 u 开始到 u 结束的回路，这条回路上仍然有些节点有未经过的出边。
     * <p>
     * 我么从某个这样的节点 v 开始，继续得到一条从 v 开始到 v 结束的回路，再嵌入之前的回路中
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
