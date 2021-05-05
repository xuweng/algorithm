package com.leetcode.tag.must2.ten;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    /**
     * 方法二：排序 + 动态规划
     */
    class Solution1 {
        public int deleteAndEarn(int[] nums) {
            int n = nums.length;
            int ans = 0;
            Arrays.sort(nums);
            List<Integer> sum = new ArrayList<>();
            sum.add(nums[0]);
            int size = 1;
            for (int i = 1; i < n; ++i) {
                int val = nums[i];
                if (val == nums[i - 1]) {
                    sum.set(size - 1, sum.get(size - 1) + val);
                } else if (val == nums[i - 1] + 1) {
                    sum.add(val);
                    ++size;
                } else {
                    ans += rob(sum);
                    sum.clear();
                    sum.add(val);
                    size = 1;
                }
            }
            ans += rob(sum);
            return ans;
        }

        public int rob(List<Integer> nums) {
            int size = nums.size();
            if (size == 1) {
                return nums.get(0);
            }
            int first = nums.get(0), second = Math.max(nums.get(0), nums.get(1));
            for (int i = 2; i < size; i++) {
                int temp = second;
                second = Math.max(first + nums.get(i), second);
                first = temp;
            }
            return second;
        }
    }

    /**
     * 打家劫舍的最优子结构的公式：
     * dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
     * <p>
     * 这个问题的最优子结构公式：
     * dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * all[i]);
     */
    class Solution2 {
        public int deleteAndEarn(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            if (nums.length == 1) {
                return nums[0];
            }
            int max = nums[0];
            for (int num : nums) {
                max = Math.max(max, num);
            }
            // 构造一个新的数组all
            int[] all = new int[max + 1];
            for (int item : nums) {
                // 计数
                all[item]++;
            }
            int[] dp = new int[max + 1];
            dp[1] = all[1];
            dp[2] = Math.max(dp[1], all[2] * 2);
            // 动态规划求解
            for (int i = 2; i <= max; ++i) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * all[i]);
            }
            return dp[max];
        }
    }
}
