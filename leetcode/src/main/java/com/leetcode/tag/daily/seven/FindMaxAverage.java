package com.leetcode.tag.daily.seven;

/**
 * 643. 子数组最大平均数 I
 */
public class FindMaxAverage {
    static class Solution {
        public double findMaxAverage(int[] nums, int k) {
            int sum = 0;
            double result = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                sum += i >= k ? nums[i] - nums[i - k] : nums[i];

                if (i >= k - 1) {
                    result = Math.max(result, sum / (double) k);
                }
            }

            return result;
        }
    }

    /**
     * 方法一：滑动窗口
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/maximum-average-subarray-i/solution/zi-shu-zu-zui-da-ping-jun-shu-i-by-leetc-us1k/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public double findMaxAverage(int[] nums, int k) {
            int sum = 0;
            int n = nums.length;
            for (int i = 0; i < k; i++) {
                sum += nums[i];
            }
            int maxSum = sum;
            for (int i = k; i < n; i++) {
                sum = sum - nums[i - k] + nums[i];
                maxSum = Math.max(maxSum, sum);
            }
            return 1.0 * maxSum / k;
        }
    }

}
