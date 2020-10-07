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

    class Solution1 {
        public void sortColors(int[] nums) {
            if (nums == null || nums.length == 0) {
                return;
            }
            int[] array = new int[3];
            for (int num : nums) {
                array[num]++;
            }
            int index = 0;
            for (int j = 0; j < array.length; j++) {
                int i = array[j];
                while (i-- > 0) {
                    nums[index++] = j;
                }
            }
        }
    }
}
