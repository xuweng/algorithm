package com.leetcode.tag.must.six;

/**
 * 1567. 乘积为正数的最长子数组长度
 */
public class GetMaxLen {
    class Solution {
        public int getMaxLen(int[] nums) {
            int length = nums.length;
            // positive[i] 表示以下标 i 结尾的乘积为正数的最长子数组长度
            int[] positive = new int[length];
            // negative[i] 表示乘积为负数的最长子数组长度 以下标i结尾
            int[] negative = new int[length];
            if (nums[0] > 0) {
                positive[0] = 1;
            } else if (nums[0] < 0) {
                negative[0] = 1;
            }
            int maxLength = positive[0];
            for (int i = 1; i < length; i++) {
                if (nums[i] > 0) {
                    // 当 nums[i]>0 时，之前的乘积乘以  nums[i] 不会改变乘积的正负性
                    // 正数*正数=正数
                    positive[i] = positive[i - 1] + 1;
                    // 负数*正数=负数
                    // negative[i - 1] == 0说明前面没有负数
                    negative[i] = negative[i - 1] == 0 ? 0 : negative[i - 1] + 1;
                } else if (nums[i] < 0) {
                    // 当 nums[i]<0 时，之前的乘积乘以 nums[i] 会改变乘积的正负性
                    // 负数*负数=正数
                    // negative[i - 1] == 0说明前面没有负数
                    positive[i] = negative[i - 1] == 0 ? 0 : negative[i - 1] + 1;
                    // 正数*负数=负数
                    negative[i] = positive[i - 1] + 1;
                } else {
                    //当 nums[i]=0 时，以下标 i 结尾的子数组的元素乘积一定为 0，
                    // 因此有positive[i]=0 和negative[i]=0。
                    positive[i] = 0;
                    negative[i] = 0;
                }
                maxLength = Math.max(maxLength, positive[i]);
            }
            return maxLength;
        }
    }
}
