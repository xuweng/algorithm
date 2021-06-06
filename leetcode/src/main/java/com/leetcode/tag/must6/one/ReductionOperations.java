package com.leetcode.tag.must6.one;

import java.util.Arrays;

/**
 * 5777. 使数组元素相等的减少操作次数
 */
public class ReductionOperations {
    /**
     * 方法一：排序
     */
    class Solution {
        public int reductionOperations(int[] nums) {
            Arrays.sort(nums);

            int n = nums.length;
            // 总操作次数
            int res = 0;
            // 每个元素操作次数
            int count = 0;
            // 从下标 1 开始顺序遍历（nums[0] 一定为最小值故无需操作）
            for (int i = 1; i < n; i++) {
                // 如果 nums[i]=nums[i−1]，此时 nums[i] 的操作次数与 nums[i−1] 相同，故 cnt 不变
                if (nums[i] != nums[i - 1]) {
                    //  nums[i] 需要首先变为 nums[i−1] 才能进行后续操作，因此我们将 cnt 增加 1
                    count++;
                }
                res += count;
            }
            return res;
        }
    }
}
