package com.leetcode.tag.daily.eight;

/**
 * 1004. 最大连续1的个数 III
 */
public class LongestOnes {
    /**
     * 方法一：二分查找
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/max-consecutive-ones-iii/solution/zui-da-lian-xu-1de-ge-shu-iii-by-leetcod-hw12/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int longestOnes(int[] A, int K) {
            int n = A.length;
            //前缀和 区间和
            int[] P = new int[n + 1];
            for (int i = 1; i <= n; ++i) {
                P[i] = P[i - 1] + (1 - A[i - 1]);
            }

            int ans = 0;
            for (int right = 0; right < n; ++right) {
                //前缀和数组是一个单调递增的数组
                int left = binarySearch(P, P[right + 1] - K);
                ans = Math.max(ans, right - left + 1);
            }
            return ans;
        }

        public int binarySearch(int[] P, int target) {
            int low = 0, high = P.length - 1;
            while (low < high) {
                int mid = (high - low) / 2 + low;
                if (P[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }
    }

    /**
     * 方法二：滑动窗口
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/max-consecutive-ones-iii/solution/zui-da-lian-xu-1de-ge-shu-iii-by-leetcod-hw12/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int longestOnes(int[] A, int K) {
            int n = A.length;
            int left = 0;
            //用两个变量 lsum 和 rsum 记录 left 和 right 分别对应的前缀和即可
            int lsum = 0, rsum = 0;
            int ans = 0;
            for (int right = 0; right < n; ++right) {
                rsum += 1 - A[right];
                while (lsum < rsum - K) {
                    lsum += 1 - A[left];
                    ++left;
                }
                ans = Math.max(ans, right - left + 1);
            }
            return ans;
        }
    }

}
