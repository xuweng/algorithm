package com.leetcode.tag.must2.seven;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 */
public class FindContinuousSequence {
    /**
     * 滑动窗口的重要性质是：窗口的左边界和右边界永远只能向右移动，而不能向左移动
     */
    class Solution {
        public int[][] findContinuousSequence(int target) {
            // 滑动窗口的左边界
            int left = 1;
            // 滑动窗口的右边界
            int right = 1;
            // 滑动窗口中数字的和
            int sum = 1;
            List<int[]> res = new ArrayList<>();

            // 至少含有两个数,假设2个数
            // 9=4+5
            // 10=5+5
            // 15=7+8
            // left最多=target/2
            while (left <= target / 2) {
                if (sum < target) {
                    // 右边界向右移动
                    sum += right;
                    right++;
                } else if (sum > target) {
                    // 左边界向右移动
                    sum -= left;
                    left++;
                } else {
                    // 记录结果
                    int[] arr = new int[right - left + 1];
                    for (int k = left; k <= right; k++) {
                        arr[k - left] = k;
                    }
                    res.add(arr);
                    // 左边界向右移动
                    sum -= left;
                    left++;
                }
            }

            return res.toArray(new int[res.size()][]);
        }
    }
}
