package com.leetcode.tag.dp.one.three;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 1477. 找两个和为目标值且不重叠的子数组
 * <p>
 * 缩小矩阵
 */
public class MinSumOfLengths {
    /**
     * 算法错误
     * <p>
     * 两个互不重叠的子数组 会计算两个重叠的子数组
     */
    class Solution {
        public int minSumOfLengths(int[] arr, int target) {
            if (arr == null || arr.length == 0) {
                return 0;
            }
            Queue<Integer> queue = new PriorityQueue<>();
            boolean[] used = new boolean[arr.length];
            for (int i = 0; i < arr.length; i++) {
                int sum = 0;
                for (int j = i; j >= 0 && sum < target && !used[j]; j--) {
                    sum += arr[j];
                    if (sum == target) {
                        for (int k = i; k >= j; k--) {
                            used[k] = true;
                        }

                        queue.offer(i - j + 1);
                    }
                }
            }
            if (queue.size() < 2) {
                return -1;
            }

            return queue.poll() + queue.poll();
        }
    }
}
