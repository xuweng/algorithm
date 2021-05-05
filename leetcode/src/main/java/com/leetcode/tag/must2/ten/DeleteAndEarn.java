package com.leetcode.tag.must2.ten;

/**
 * 740. 删除并获得点数
 */
public class DeleteAndEarn {
    /**
     * 方法一：动态规划
     * <p>
     * 与「198. 打家劫舍」是一样的
     * <p>
     * 若选择了 x，则可以获取 sum[x] 的点数，且无法再选择 x−1 和 x+1
     */
    class Solution {
        public int deleteAndEarn(int[] nums) {
            int maxVal = 0;
            for (int val : nums) {
                maxVal = Math.max(maxVal, val);
            }
            int[] sum = new int[maxVal + 1];
            for (int val : nums) {
                sum[val] += val;
            }
            return rob(sum);
        }

        public int rob(int[] nums) {
            int size = nums.length;
            int first = nums[0], second = Math.max(nums[0], nums[1]);
            for (int i = 2; i < size; i++) {
                int temp = second;
                second = Math.max(first + nums[i], second);
                first = temp;
            }
            return second;
        }
    }
}
