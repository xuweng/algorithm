package com.leetcode.tag.daily.four;

/**
 * 845. 数组中的最长山脉
 * <p>
 * 十分钟.十分钟.十分钟.十分钟.
 */
public class LongestMountain {
    /**
     * 方法一：枚举山顶
     * <p>
     * 可以考虑枚举山顶，再从山顶向左右两侧扩展找到山脚
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/longest-mountain-in-array/solution/shu-zu-zhong-de-zui-chang-shan-mai-by-leetcode-sol/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int longestMountain(int[] A) {
            int n = A.length;
            if (n == 0) {
                return 0;
            }
            int[] left = new int[n];
            for (int i = 1; i < n; ++i) {
                left[i] = A[i - 1] < A[i] ? left[i - 1] + 1 : 0;
            }
            int[] right = new int[n];
            for (int i = n - 2; i >= 0; --i) {
                right[i] = A[i + 1] < A[i] ? right[i + 1] + 1 : 0;
            }

            int ans = 0;
            for (int i = 0; i < n; ++i) {
                if (left[i] > 0 && right[i] > 0) {
                    ans = Math.max(ans, left[i] + right[i] + 1);
                }
            }
            return ans;
        }
    }

}
