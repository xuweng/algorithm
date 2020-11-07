package com.leetcode.tag.binarysearch.one;

import java.util.Arrays;

/**
 * 668. 乘法表中第k小的数
 */
public class FindKthNumber {
    /**
     * 方法一：暴力法[超过内存限制]
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/kth-smallest-number-in-multiplication-table/solution/cheng-fa-biao-zhong-di-kxiao-de-shu-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int findKthNumber(int m, int n, int k) {
            int[] table = new int[m * n];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    table[(i - 1) * n + j - 1] = i * j;
                }
            }
            Arrays.sort(table);
            return table[k - 1];
        }
    }

}
