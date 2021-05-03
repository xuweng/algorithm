package com.leetcode.tag.must2.eight;

import java.util.HashMap;
import java.util.Map;

/**
 * 697. 数组的度
 */
public class FindShortestSubArray {
    /**
     * 方法一：哈希表
     */
    class Solution {
        public int findShortestSubArray(int[] nums) {
            // 记原数组中出现次数最多的数为 x，那么和原数组的度相同的最短连续子数组，必然包含了原数组中的全部 x，且两端恰为 x 第一次出现和最后一次出现的位置
            // 每一个数映射到一个长度为 3 的数组，
            // 数组中的三个元素分别代表这个数出现的次数、这个数在原数组中第一次出现的位置、这个数在原数组中最后一次出现的位置
            Map<Integer, int[]> map = new HashMap<>();
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                if (map.containsKey(nums[i])) {
                    // 更新次数
                    map.get(nums[i])[0]++;
                    // 更新最后位置
                    map.get(nums[i])[2] = i;
                } else {
                    map.put(nums[i], new int[]{1, i, i});
                }
            }
            int maxNum = 0, minLen = 0;
            for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
                int[] arr = entry.getValue();
                // 任一元素出现频数的最大值
                if (maxNum < arr[0]) {
                    maxNum = arr[0];
                    // 遇到最大值就直接更新
                    minLen = arr[2] - arr[1] + 1;
                } else if (maxNum == arr[0]) {
                    // 多个重复的最大值,取最小值
                    minLen = Math.min(minLen, arr[2] - arr[1] + 1);
                }
            }
            return minLen;
        }
    }
}
