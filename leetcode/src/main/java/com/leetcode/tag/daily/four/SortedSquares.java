package com.leetcode.tag.daily.four;

import java.util.Arrays;

/**
 * 977. 有序数组的平方
 */
public class SortedSquares {
    class Solution {
        public int[] sortedSquares(int[] A) {
            if (A == null || A.length == 0) {
                return new int[0];
            }
            for (int i = A.length - 1; i >= 0; i--) {
                if (Math.abs(A[i]) < Math.abs(A[0])) {
                    int temp = A[0];
                    A[0] = A[i];
                    A[i] = temp;
                }
                A[i] = A[i] * A[i];
            }
            Arrays.sort(A);

            return A;
        }
    }

    /**
     * 方法一：直接排序
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array/solution/you-xu-shu-zu-de-ping-fang-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int[] sortedSquares(int[] A) {
            int[] ans = new int[A.length];
            for (int i = 0; i < A.length; ++i) {
                ans[i] = A[i] * A[i];
            }
            Arrays.sort(ans);
            return ans;
        }
    }

    /**
     * 方法二：双指针
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array/solution/you-xu-shu-zu-de-ping-fang-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public int[] sortedSquares(int[] A) {
            int n = A.length;
            int negative = -1;
            for (int i = 0; i < n; ++i) {
                if (A[i] < 0) {
                    negative = i;
                } else {
                    break;
                }
            }

            int[] ans = new int[n];
            int index = 0, i = negative, j = negative + 1;
            while (i >= 0 || j < n) {
                if (i < 0) {
                    ans[index] = A[j] * A[j];
                    ++j;
                } else if (j == n) {
                    ans[index] = A[i] * A[i];
                    --i;
                } else if (A[i] * A[i] < A[j] * A[j]) {
                    ans[index] = A[i] * A[i];
                    --i;
                } else {
                    ans[index] = A[j] * A[j];
                    ++j;
                }
                ++index;
            }

            return ans;
        }
    }

}
