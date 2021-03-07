package com.leetcode.tag.dp.one.three;

import java.util.Arrays;
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
     * <p>
     * [2,1,3,3,2,3,1]
     * 6
     * <p>
     * 2,1,3  2,3,1    6
     * <p>
     * 3,3    2,3,1    5
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

    /**
     * 双指针  滑动窗口
     * <p>
     * 滑动窗口+动态规划
     * <p>
     * 连续 滑动窗口 前缀和
     * <p>
     * 作者：antione
     * 链接：https://leetcode-cn.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/solution/yi-ci-bian-li-hua-dong-chuang-kou-jia-dong-tai-gui/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int minSumOfLengths(int[] arr, int target) {
            int n = arr.length;
            // 表示当前j以及j之前的满足条件的最小区间长度
            int[] dp = new int[n];
            // 注意不能设置为最大值，因为相加会溢出
            Arrays.fill(dp, Integer.MAX_VALUE / 2);
            // 当前以j结尾的满足条件的区间长度与i-1之前的最小的区间长度之和，这样就能满足两个窗口不重叠且长度之和最小
            int ans = Integer.MAX_VALUE;
            int sum = 0;
            int left = 0;
            for (int i = 0; i < n; i++) {
                sum += arr[i];
                while (left <= i && sum > target) {
                    sum -= arr[left++];
                }
                // 找到满足条件的一个区间 [left,i]
                if (sum == target) {
                    if (left != 0) {
                        ans = Math.min(ans, dp[left - 1] + i - left + 1);
                    }
                }
                if (i != 0) {
                    dp[i] = Math.min(i - left + 1, dp[i - 1]);
                }
            }

            return ans > arr.length ? -1 : ans;
        }
    }

}
