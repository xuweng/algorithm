package com.leetcode.tag.dp.three;

/**
 * 53. 最大子序和
 * <p>
 * 脑里按照示例跑一遍代码
 * <p>
 * 自己写一遍 自己写一笔 自己写一遍 自己写一遍 自己写一遍 自己写一遍
 * <p>
 * 记住常见dp状态定义 记住常见dp状态定义 记住常见dp状态定义
 */
public class MaxSubArray {
    class Solution {
        public int maxSubArray(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                dp[i] = nums[i];
                if (dp[i - 1] > 0) {
                    dp[i] = dp[i - 1] + nums[i];
                }
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }

    /**
     * 方法一：动态规划
     * <p>
     * 记住常见题型 记住常见dp状态定义
     * <p>
     * 简洁代码 简洁代码 简洁代码
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/maximum-subarray/solution/zui-da-zi-xu-he-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int maxSubArray(int[] nums) {
            int pre = 0, maxAns = nums[0];
            for (int x : nums) {
                pre = Math.max(pre + x, x);
                maxAns = Math.max(maxAns, pre);
            }
            return maxAns;
        }
    }

    /**
     * 方法二：分治
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/maximum-subarray/solution/zui-da-zi-xu-he-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
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

        /**
         * 定义一个操作 get(a, l, r) 表示查询 a 序列 [l,r] 区间内的最大子段和
         *
         * @param a
         * @param l
         * @param r
         * @return
         */
        public Status getInfo(int[] a, int l, int r) {
            if (l == r) {
                return new Status(a[l], a[l], a[l], a[l]);
            }
            int m = (l + r) >> 1;
            Status lSub = getInfo(a, l, m);
            Status rSub = getInfo(a, m + 1, r);
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
