package com.leetcode.tag.dp.three;

/**
 * 978. 最长湍流子数组
 * <p>
 * 一题多刷 一题多刷 一题多刷 一题多刷 一题多刷 一题多刷
 */
public class MaxTurbulenceSize {
    class Solution {
        public int maxTurbulenceSize(int[] arr) {
            if (arr == null || arr.length == 0) {
                return 0;
            }
            int[] dp = new int[arr.length];
            int[] dp1 = new int[arr.length];
            dp[0] = 1;
            dp1[0] = 1;
            int max = 1;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > arr[i - 1]) {
                    dp[i] = dp1[i - 1] + 1;
                    dp1[i] = 1;
                } else if (arr[i] < arr[i - 1]) {
                    dp1[i] = dp[i - 1] + 1;
                    dp[i] = 1;
                } else {
                    dp[i] = 1;
                    dp1[i] = 1;
                }
                max = Math.max(max, Math.max(dp[i], dp1[i]));
            }
            return max;
        }
    }

    /**
     * 方法：滑动窗口
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/longest-turbulent-subarray/solution/zui-chang-tuan-liu-zi-shu-zu-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int maxTurbulenceSize(int[] A) {
            int N = A.length;
            int ans = 1;
            int anchor = 0;

            for (int i = 1; i < N; ++i) {
                int c = Integer.compare(A[i - 1], A[i]);
                if (i == N - 1 || c * Integer.compare(A[i], A[i + 1]) != -1) {
                    if (c != 0) {
                        ans = Math.max(ans, i - anchor + 1);
                    }
                    anchor = i;
                }
            }

            return ans;
        }
    }

}
