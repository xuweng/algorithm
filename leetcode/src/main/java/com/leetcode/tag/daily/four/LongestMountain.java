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
            // 从左侧山脚到山顶的序列是严格单调递增
            int[] left = new int[n];
            for (int i = 1; i < n; ++i) {
                left[i] = A[i - 1] < A[i] ? left[i - 1] + 1 : 0;
            }
            // 山顶到右侧山脚的序列是严格单调递减
            int[] right = new int[n];
            for (int i = n - 2; i >= 0; --i) {
                right[i] = A[i + 1] < A[i] ? right[i + 1] + 1 : 0;
            }

            // 只有当 left[i] 和 right[i] 均大于 0 时，A[i] 才能作为山顶，并且山脉的长度为 left[i] + right[i] + 1。
            int ans = 0;
            for (int i = 0; i < n; ++i) {
                if (left[i] > 0 && right[i] > 0) {
                    ans = Math.max(ans, left[i] + right[i] + 1);
                }
            }
            return ans;
        }
    }

    /**
     * 方法二：枚举山脚
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/longest-mountain-in-array/solution/shu-zu-zhong-de-zui-chang-shan-mai-by-leetcode-sol/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int longestMountain(int[] A) {
            int n = A.length;
            int ans = 0;
            // 一个指针枚举左侧山脚
            int left = 0;
            while (left + 2 < n) {
                // 另一个指针不断向右移动到右侧山脚
                int right = left + 1;
                if (A[left] < A[left + 1]) {
                    while (right + 1 < n && A[right] < A[right + 1]) {
                        ++right;
                    }
                    if (right < n - 1 && A[right] > A[right + 1]) {
                        while (right + 1 < n && A[right] > A[right + 1]) {
                            ++right;
                        }
                        ans = Math.max(ans, right - left + 1);
                    } else {
                        ++right;
                    }
                }
                // 右侧山脚有可能是下一个左侧山脚，因此我们需要将 right 的值赋予 left，以便与进行下一次枚举
                left = right;
            }
            return ans;
        }
    }

    /**
     * 枚举山顶
     */
    class Solution2 {
        public int longestMountain(int[] A) {
            int ans = 2;
            int l = A.length;
            for (int i = 1; i < l - 1; i++) {
                //先找到山顶
                if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                    int j = i - 1;
                    int k = i + 1;
                    // 枚举左山脚
                    while (j >= 0 && A[j] < A[j + 1]) {
                        j--;
                    }
                    // 枚举右山脚
                    while (k < l && A[k] < A[k - 1]) {
                        k++;
                    }
                    ans = Math.max(ans, k - j - 1);
                }
            }
            return ans == 2 ? 0 : ans;
        }
    }

}
