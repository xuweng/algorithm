package com.leetcode.tag.daily.five;

/**
 * 922. 按奇偶排序数组 II
 */
public class SortArrayByParityII {
    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/sort-array-by-parity-ii/solution/an-qi-ou-pai-xu-shu-zu-ii-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int[] sortArrayByParityII(int[] A) {
            int n = A.length;
            int[] ans = new int[n];

            int i = 0;
            for (int x : A) {
                if (x % 2 == 0) {
                    // 偶数
                    ans[i] = x;
                    i += 2;
                }
            }
            i = 1;
            for (int x : A) {
                if (x % 2 == 1) {
                    // 奇数
                    ans[i] = x;
                    i += 2;
                }
            }
            return ans;
        }
    }

}
