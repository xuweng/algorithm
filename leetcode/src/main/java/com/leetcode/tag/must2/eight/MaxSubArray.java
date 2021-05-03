package com.leetcode.tag.must2.eight;

/**
 * 53. 最大子序和
 */
public class MaxSubArray {
    class Solution {
        public int maxSubArray(int[] nums) {
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 1], 0) + nums[i];

                max = Math.max(max, dp[i]);
            }

            return max;
        }
    }

    class Solution1 {
        public int maxSubArray(int[] nums) {
            int pre = nums[0];
            int cur;
            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                cur = Math.max(pre, 0) + nums[i];
                pre = cur;

                max = Math.max(max, cur);
            }

            return max;
        }
    }

    /**
     * 方法二：分治
     */
    class Solution2 {
        public class Status {
            public int lSum, rSum, mSum, iSum;

            public Status(int lSum, int rSum, int mSum, int iSum) {
                this.lSum = lSum;
                this.rSum = rSum;
                this.mSum = mSum;
                this.iSum = iSum;
            }
        }

        public int maxSubArray(int[] nums) {
            return getInfo(nums, 0, nums.length - 1).mSum;
        }

        public Status getInfo(int[] a, int left, int right) {
            if (left == right) {
                return new Status(a[left], a[left], a[left], a[left]);
            }
            int mid = (left + right) >> 1;
            Status lSub = getInfo(a, left, mid);
            Status rSub = getInfo(a, mid + 1, right);
            return pushUp(lSub, rSub);
        }

        public Status pushUp(Status l, Status r) {
            int iSum = l.iSum + r.iSum;
            int lSum = Math.max(l.lSum, l.iSum + r.lSum);
            int rSum = Math.max(r.rSum, r.iSum + l.rSum);
            int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
            return new Status(lSum, rSum, mSum, iSum);
        }
    }
}
