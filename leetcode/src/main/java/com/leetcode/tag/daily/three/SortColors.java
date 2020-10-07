package com.leetcode.tag.daily.three;

import java.util.Arrays;

/**
 * 75. 颜色分类
 */
public class SortColors {
    class Solution {
        public void sortColors(int[] nums) {
            if (nums == null || nums.length == 0) {
                return;
            }
            Arrays.sort(nums);
        }
    }
}
