package com.leetcode.tag.daily.four;

/**
 * 941. 有效的山脉数组
 */
public class ValidMountainArray {
    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/valid-mountain-array/solution/you-xiao-de-shan-mai-shu-zu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public boolean validMountainArray(int[] A) {
            int n = A.length;
            int i = 0;

            // 递增扫描
            while (i + 1 < n && A[i] < A[i + 1]) {
                i++;
            }

            // 最高点不能是数组的第一个位置或最后一个位置
            if (i == 0 || i == n - 1) {
                return false;
            }

            // 递减扫描
            while (i + 1 < n && A[i] > A[i + 1]) {
                i++;
            }

            return i == n - 1;
        }
    }

}
